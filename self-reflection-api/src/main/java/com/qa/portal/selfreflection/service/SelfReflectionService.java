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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SelfReflectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelfReflectionService.class);

    @Autowired
    private QaUserRepository qaUserRepository;

    @Autowired
    private SelfReflectionServiceMapper selfReflectionServiceMapper;

    @Autowired
    private SelfReflectionFormRepository selfReflectionFormRepository;


    @Transactional
    public List<SelfReflectionFormDto> getSelfReflections(String userName) {
        try {
            Optional<QaUserEntity> qaUser = qaUserRepository.findByUserName(userName);

            List<SelfReflectionFormDto> dtos = qaUser.map(user -> getSelfReflectionsFormEntities(user)
            ).map(entities -> selfReflectionServiceMapper.createSelfReflectionFormDtos(entities)
            ).orElseGet(Collections::emptyList);
            LOGGER.info("DTOs being returned are");
            dtos.stream().forEach((dto) -> LOGGER.info(dto.toString()));
            return dtos;
        }
        catch (Exception e) {
            LOGGER.error("Exception is " + e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    private List<SelfReflectionFormEntity> getSelfReflectionsFormEntities(QaUserEntity qaUserEntity) {
        List<SelfReflectionFormEntity> entities = selfReflectionFormRepository.findByQaUser(qaUserEntity);
        LOGGER.info("Self Reflection entities are ");
        entities.stream().forEach(e -> LOGGER.info(e.toString()));
        return entities;
    }
}
