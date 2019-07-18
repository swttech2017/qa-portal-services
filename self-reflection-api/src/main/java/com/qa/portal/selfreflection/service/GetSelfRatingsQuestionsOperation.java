package com.qa.portal.selfreflection.service;

import com.qa.portal.common.util.mapper.BaseMapper;
import com.qa.portal.selfreflection.dto.SelfRatingQuestionDto;
import com.qa.portal.selfreflection.persistence.repository.SelfRatingQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSelfRatingsQuestionsOperation {

    @Autowired
    private SelfRatingQuestionRepository selfRatingQuestionRepository;

    @Autowired
    private BaseMapper baseMapper;

    public List<SelfRatingQuestionDto> getSelfRatingQuestons() {
        return this.selfRatingQuestionRepository.findAll().stream()
                .map(srqe -> baseMapper.mapObject(srqe, SelfRatingQuestionDto.class))
                .collect(Collectors.toList());
    }
}
