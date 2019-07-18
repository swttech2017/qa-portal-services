package com.qa.portal.selfreflection.service;

import com.qa.portal.selfreflection.dto.SelfRatingQuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SelfRatingQuestionsService {
    @Autowired
    private GetSelfRatingsQuestionsOperation getSelfRatingsQuestionsOperation;

    @Transactional
    public List<SelfRatingQuestionDto> getSelfRatingQuestons() {
        return getSelfRatingsQuestionsOperation.getSelfRatingQuestons();
    }
}
