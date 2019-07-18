package com.qa.portal.selfreflection.rest;

import com.qa.portal.selfreflection.dto.SelfRatingQuestionDto;
import com.qa.portal.selfreflection.service.SelfRatingQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.qa.portal.selfreflection.SelfReflectionConstants.SELF_RATINGS_API_URL;
import static com.qa.portal.selfreflection.SelfReflectionConstants.SELF_RATINGS_QUESTIONS;

@RestController
@RequestMapping(value = SELF_RATINGS_API_URL)
public class SelfRatingQuestionsController {

    @Autowired
    private SelfRatingQuestionsService selfRatingQuestionsService;

    @GetMapping(value = SELF_RATINGS_QUESTIONS)
    public List<SelfRatingQuestionDto> getSelfRatingQuestions() {
        return this.selfRatingQuestionsService.getSelfRatingQuestons();
    }
}
