package com.qa.portal.selfreflection.persistence.repository;

import com.qa.portal.selfreflection.persistence.entity.SelfReflectionReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfReflectionReviewRepository extends JpaRepository<SelfReflectionReviewEntity, Integer> {
}
