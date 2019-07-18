package com.qa.portal.selfreflection.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.portal.common.persistence.entity.QaBaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema="training", name="self_rating")
public class SelfRatingEntity extends QaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "self_rating_sequence")
    @SequenceGenerator(name = "self_rating_sequence", sequenceName = "training.self_rating_sequence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "self_rating_question_id")
    private SelfRatingQuestionEntity selfRatingQuestion;

    @ManyToOne
    @JoinColumn(name = "qa_user_self_reflection_form_id")
    @JsonIgnore
    private SelfReflectionFormEntity qaUserSelfReflectionForm;

    @Column(name = "selected_rating")
    private Integer selectedRating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SelfRatingQuestionEntity getSelfRatingQuestion() {
        return selfRatingQuestion;
    }

    public void setSelfRatingQuestion(SelfRatingQuestionEntity selfRatingQuestion) {
        this.selfRatingQuestion = selfRatingQuestion;
    }

    public SelfReflectionFormEntity getQaUserSelfReflectionForm() {
        return qaUserSelfReflectionForm;
    }

    public void setQaUserSelfReflectionForm(SelfReflectionFormEntity qaUserSelfReflectionForm) {
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
        SelfRatingEntity that = (SelfRatingEntity) o;
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
        return "SelfRatingEntity{" +
                "id=" + id +
                ", selfRatingQuestion=" + selfRatingQuestion +
                ", selectedRating=" + selectedRating +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
