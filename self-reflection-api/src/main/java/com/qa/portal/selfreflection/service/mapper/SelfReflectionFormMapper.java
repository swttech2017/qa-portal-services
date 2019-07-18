package com.qa.portal.selfreflection.service.mapper;

import com.qa.portal.common.exception.QaResourceNotFoundException;
import com.qa.portal.common.persistence.entity.QaUserEntity;
import com.qa.portal.common.persistence.repository.QaUserRepository;
import com.qa.portal.common.util.mapper.BaseMapper;
import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import com.qa.portal.selfreflection.dto.SelfReflectionFormStatusDto;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SelfReflectionFormMapper {

    private static Logger LOGGER = LoggerFactory.getLogger(SelfReflectionFormMapper.class);

    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private SelfReflectionFormStatusMapper selfReflectionFormStatusMapper;

    @Autowired
    private QaUserRepository userRepository;

    public List<SelfReflectionFormDto> createSelfReflectionFormDtos(List<SelfReflectionFormEntity> entities) {
        List<SelfReflectionFormDto> selfReflectionFormDtos = entities.stream()
                .map(entity -> baseMapper.mapObject(entity, SelfReflectionFormDto.class))
                .collect(Collectors.toList());
        selfReflectionFormDtos.stream().forEach((srf) -> srf.getQaUserSelfReflectionFormStatuses().sort(
                Comparator.comparingLong((SelfReflectionFormStatusDto status) ->
                        status.getLastUpdatedTimestamp().getLong(ChronoField.NANO_OF_SECOND))));
        return selfReflectionFormDtos;
    }

    public SelfReflectionFormEntity createSelfReflectionFormEntity(SelfReflectionFormDto selfReflectionFormDto, String userName) {
        SelfReflectionFormEntity sre = baseMapper.mapObject(selfReflectionFormDto, SelfReflectionFormEntity.class);
        sre.setQaUser(getQaUser(userName));
        setSelfRatingForeignKeys(sre);
        addSelfReflectionFormStatusEntity(sre, selfReflectionFormDto.getCurrentStatus());
        return sre;
    }

    private void addSelfReflectionFormStatusEntity(SelfReflectionFormEntity sre, String status) {
        sre.setQaUserSelfReflectionFormStatuses(new ArrayList<>());
        sre.getQaUserSelfReflectionFormStatuses().add(selfReflectionFormStatusMapper.createSelfReflectionFormStatusEntity(sre, status));
    }

    private void setSelfRatingForeignKeys(SelfReflectionFormEntity sre) {
        sre.getSelfRatings().stream()
                .forEach(sr -> sr.setQaUserSelfReflectionForm(sre));
    }

    private QaUserEntity getQaUser(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(() -> new QaResourceNotFoundException("User not found"));
    }
}
