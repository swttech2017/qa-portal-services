package com.qa.portal.selfreflection.dto;

import com.qa.portal.common.dto.QaBaseDto;
import com.qa.portal.common.dto.QaUserDto;

import java.util.Objects;

public class SelfReflectionReviewDto extends QaBaseDto {

    private Integer id;

    private QaUserDto reviewer;

    private SelfReflectionFormDto qaUserSelfReflectionForm;

    private String trainerComments;

    private String learningPathway;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QaUserDto getReviewer() {
        return reviewer;
    }

    public void setReviewer(QaUserDto reviewer) {
        this.reviewer = reviewer;
    }

    public SelfReflectionFormDto getQaUserSelfReflectionForm() {
        return qaUserSelfReflectionForm;
    }

    public void setQaUserSelfReflectionForm(SelfReflectionFormDto qaUserSelfReflectionForm) {
        this.qaUserSelfReflectionForm = qaUserSelfReflectionForm;
    }

    public String getTrainerComments() {
        return trainerComments;
    }

    public void setTrainerComments(String trainerComments) {
        this.trainerComments = trainerComments;
    }

    public String getLearningPathway() {
        return learningPathway;
    }

    public void setLearningPathway(String learningPathway) {
        this.learningPathway = learningPathway;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfReflectionReviewDto that = (SelfReflectionReviewDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reviewer, that.reviewer) &&
                Objects.equals(qaUserSelfReflectionForm, that.qaUserSelfReflectionForm) &&
                Objects.equals(trainerComments, that.trainerComments) &&
                Objects.equals(learningPathway, that.learningPathway) &&
                Objects.equals(lastUpdatedTimestamp, that.lastUpdatedTimestamp) &&
                Objects.equals(lastUpdatedBy, that.lastUpdatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewer, qaUserSelfReflectionForm, trainerComments, learningPathway, lastUpdatedTimestamp, lastUpdatedBy);
    }

    @Override
    public String toString() {
        return "SelfReflectionReviewDto{" +
                "id=" + id +
                ", reviewer=" + reviewer +
                ", trainerComments='" + trainerComments + '\'' +
                ", learningPathway='" + learningPathway + '\'' +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
