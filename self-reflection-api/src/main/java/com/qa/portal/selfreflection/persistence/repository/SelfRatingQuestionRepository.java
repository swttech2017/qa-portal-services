package com.qa.portal.selfreflection.persistence.repository;

import com.qa.portal.selfreflection.persistence.entity.SelfRatingQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class SelfRatingQuestionRepository implements JpaRepository<SelfRatingQuestionEntity, Integer> {
}
