package com.qa.portal.selfreflection.service.mapper;

import com.qa.portal.common.util.mapper.BaseMapper;
import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import com.qa.portal.selfreflection.dto.SelfReflectionFormStatusDto;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class SelfReflectionServiceMapper {

    private static Logger LOGGER = LoggerFactory.getLogger(SelfReflectionServiceMapper.class);

    @Autowired
    private BaseMapper baseMapper;

    public List<SelfReflectionFormDto> createSelfReflectionFormDtos(List<SelfReflectionFormEntity> entities) {
        List<SelfReflectionFormDto> selfReflectionFormDtos = entities.stream()
                .map(entity -> baseMapper.mapObject(entity, SelfReflectionFormDto.class))
                .collect(Collectors.toList());
        selfReflectionFormDtos.stream().forEach((srf) -> srf.getQaUserSelfReflectionFormStatuses().sort(
                Comparator.comparingLong((SelfReflectionFormStatusDto status) ->
                        status.getLastUpdatedTimestamp().getLong(ChronoField.NANO_OF_SECOND))));
        return selfReflectionFormDtos;
    }
}
