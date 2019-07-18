package com.qa.portal.selfreflection.service.mapper;

import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SelfReflectionServiceMapper {

    private static Logger LOGGER = LoggerFactory.getLogger(SelfReflectionServiceMapper.class);

    @Autowired
    private SelfReflectionFormMapper selfReflectionFormMapper;

    public SelfReflectionFormEntity createSelfReflectionFormEntity(SelfReflectionFormDto selfReflectionFormDto, String userName) {
        return selfReflectionFormMapper.createSelfReflectionFormEntity(selfReflectionFormDto, userName);
    }

    public List<SelfReflectionFormDto> createSelfReflectionFormDtos(List<SelfReflectionFormEntity> entities) {
        return selfReflectionFormMapper.createSelfReflectionFormDtos(entities);
    }

}
