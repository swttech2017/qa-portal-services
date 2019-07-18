package com.qa.portal.selfreflection.service;

import com.qa.portal.common.persistence.entity.QaUserEntity;
import com.qa.portal.common.persistence.repository.QaUserRepository;
import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import com.qa.portal.selfreflection.persistence.repository.SelfReflectionFormRepository;
import com.qa.portal.selfreflection.service.mapper.SelfReflectionServiceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class RetrieveSelfReflectionsOperation {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetrieveSelfReflectionsOperation.class);

    @Autowired
    private QaUserRepository qaUserRepository;

    @Autowired
    private SelfReflectionServiceMapper selfReflectionServiceMapper;

    @Autowired
    private SelfReflectionFormRepository selfReflectionFormRepository;

    public List<SelfReflectionFormDto> getSelfReflections(String userName) {
        Optional<QaUserEntity> qaUser = qaUserRepository.findByUserName(userName);

        return qaUser.map(user -> getSelfReflectionsFormEntities(user))
                .map(entities -> selfReflectionServiceMapper.createSelfReflectionFormDtos(entities))
                .orElseGet(Collections::emptyList);
    }

    private List<SelfReflectionFormEntity> getSelfReflectionsFormEntities(QaUserEntity qaUserEntity) {
        List<SelfReflectionFormEntity> entities = selfReflectionFormRepository.findByQaUser(qaUserEntity);
        return entities;
    }
}
