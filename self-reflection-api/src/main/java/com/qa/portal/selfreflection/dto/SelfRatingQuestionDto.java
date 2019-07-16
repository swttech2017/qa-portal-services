package com.qa.portal.selfreflection.dto;

import java.util.Objects;

public class SelfRatingQuestionDto {

    private Integer id;

    private String questionText;

    private Integer numOptions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getNumOptions() {
        return numOptions;
    }

    public void setNumOptions(Integer numOptions) {
        this.numOptions = numOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfRatingQuestionDto that = (SelfRatingQuestionDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(questionText, that.questionText) &&
                Objects.equals(numOptions, that.numOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, numOptions);
    }

    @Override
    public String toString() {
        return "SelfRatingQuestionDto{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", numOptions=" + numOptions +
                '}';
    }
}
