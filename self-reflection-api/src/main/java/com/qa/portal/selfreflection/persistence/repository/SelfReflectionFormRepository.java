package com.qa.portal.selfreflection.persistence.repository;

import com.qa.portal.common.persistence.entity.QaUserEntity;
import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SelfReflectionFormRepository extends JpaRepository<SelfReflectionFormEntity, Integer> {

    List<SelfReflectionFormEntity> findByQaUser(QaUserEntity qaUserEntity);

    Optional<SelfReflectionFormEntity> findByWeekCommencing(Date weekCommencing);
}
