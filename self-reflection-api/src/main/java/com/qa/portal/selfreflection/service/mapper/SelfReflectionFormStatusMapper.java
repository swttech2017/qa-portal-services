package com.qa.portal.selfreflection.service.mapper;

import com.qa.portal.common.exception.QaResourceNotFoundException;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormStatusEntity;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionStatusEntity;
import com.qa.portal.selfreflection.persistence.repository.SelfReflectionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SelfReflectionFormStatusMapper {

    @Autowired
    private SelfReflectionStatusRepository selfReflectionStatusRepository;

    public SelfReflectionFormStatusEntity createSelfReflectionFormStatusEntity(SelfReflectionFormEntity sre, String status) {
        Optional<SelfReflectionStatusEntity> srs = selfReflectionStatusRepository.findByStatusText(status);
        return srs.map(entity -> createSelfReflectionFormStatusEntity(sre, entity))
                .orElseThrow(() -> new QaResourceNotFoundException("No status for the self reflection form"));
    }

    private SelfReflectionFormStatusEntity createSelfReflectionFormStatusEntity(SelfReflectionFormEntity sre, SelfReflectionStatusEntity srs) {
        SelfReflectionFormStatusEntity srfs = new SelfReflectionFormStatusEntity();
        srfs.setQaUserSelfReflectionForm(sre);
        srfs.setSelfReflectionStatus(srs);
        srfs.setUpdatingUser(sre.getQaUser());
        return srfs;
    }
}
