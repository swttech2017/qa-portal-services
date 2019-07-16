package com.qa.portal.selfreflection.persistence.repository;

import com.qa.portal.common.persistence.entity.QaUserEntity;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelfReflectionFormRepository extends JpaRepository<SelfReflectionFormEntity, Integer> {

    List<SelfReflectionFormEntity> findByQaUser(QaUserEntity qaUserEntity);
}
