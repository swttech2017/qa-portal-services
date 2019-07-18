package com.qa.portal.selfreflection.service;

import com.qa.portal.common.exception.QaPortalBusinessException;
import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import com.qa.portal.selfreflection.persistence.repository.SelfReflectionFormRepository;
import com.qa.portal.selfreflection.service.mapper.SelfReflectionServiceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Optional;

@Component
public class CreateSelfReflectionOperation {

    private final Logger LOGGER = LoggerFactory.getLogger(CreateSelfReflectionOperation.class);

    @Autowired
    private SelfReflectionFormRepository selfReflectionFormRepository;

    @Autowired
    private SelfReflectionServiceMapper selfReflectionServiceMapper;

    public SelfReflectionFormDto createSelfReflection(SelfReflectionFormDto selfReflectionFormDto, String userName) {
//        validateSelfReflection(selfReflectionFormDto);
        selfReflectionFormRepository.save(selfReflectionServiceMapper.createSelfReflectionFormEntity(selfReflectionFormDto, userName));
        return selfReflectionFormDto;
    }

    private void validateSelfReflection(SelfReflectionFormDto selfReflectionFormDto) {
        Optional<SelfReflectionFormEntity> selfReflectionFormEntity =
                selfReflectionFormRepository.findByWeekCommencing(Date.valueOf(selfReflectionFormDto.getWeekCommencing()));
        selfReflectionFormEntity.ifPresent((sre) -> {
            throw new QaPortalBusinessException("Self Reflection Form already exists for week commencing " + selfReflectionFormDto.getWeekCommencing());
        });
    }
}
