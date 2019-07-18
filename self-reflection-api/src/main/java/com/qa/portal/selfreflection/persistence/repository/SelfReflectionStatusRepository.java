package com.qa.portal.selfreflection.persistence.repository;

import com.qa.portal.selfreflection.persistence.entity.SelfReflectionStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SelfReflectionStatusRepository extends JpaRepository<SelfReflectionStatusEntity, Integer> {
    Optional<SelfReflectionStatusEntity> findByStatusText(String statusText);
}
