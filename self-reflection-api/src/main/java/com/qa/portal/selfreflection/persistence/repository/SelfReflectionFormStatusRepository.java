package com.qa.portal.selfreflection.persistence.repository;

import com.qa.portal.selfreflection.persistence.entity.SelfReflectionFormStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfReflectionFormStatusRepository extends JpaRepository<SelfReflectionFormStatusEntity, Integer> {
}
