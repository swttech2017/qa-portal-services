package com.qa.portal.selfreflection.dto;

import java.util.Objects;

public class SelfRatingDto {

    private Integer id;

    private SelfRatingQuestionDto selfRatingQuestion;

    private SelfReflectionFormDto qaUserSelfReflectionForm;

    private Integer selectedRating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SelfRatingQuestionDto getSelfRatingQuestion() {
        return selfRatingQuestion;
    }

    public void setSelfRatingQuestion(SelfRatingQuestionDto selfRatingQuestion) {
        this.selfRatingQuestion = selfRatingQuestion;
    }

    public SelfReflectionFormDto getQaUserSelfReflectionForm() {
        return qaUserSelfReflectionForm;
    }

    public void setQaUserSelfReflectionForm(SelfReflectionFormDto qaUserSelfReflectionForm) {
        this.qaUserSelfReflectionForm = qaUserSelfReflectionForm;
    }

    public Integer getSelectedRating() {
        return selectedRating;
    }

    public void setSelectedRating(Integer selectedRating) {
        this.selectedRating = selectedRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfRatingDto that = (SelfRatingDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(selfRatingQuestion, that.selfRatingQuestion) &&
                Objects.equals(qaUserSelfReflectionForm, that.qaUserSelfReflectionForm) &&
                Objects.equals(selectedRating, that.selectedRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, selfRatingQuestion, qaUserSelfReflectionForm, selectedRating);
    }

    @Override
    public String toString() {
        return "SelfRatingDto{" +
                "id=" + id +
                ", selfRatingQuestion=" + selfRatingQuestion +
                ", selectedRating=" + selectedRating +
                '}';
    }
}
