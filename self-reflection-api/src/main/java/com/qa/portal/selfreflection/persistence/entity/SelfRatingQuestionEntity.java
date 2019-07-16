package com.qa.portal.selfreflection.persistence.entity;

import com.qa.portal.common.persistence.entity.QaBaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema="training", name="self_rating_question")
public class SelfRatingQuestionEntity extends QaBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "self_rating_question_sequence")
    @SequenceGenerator(name = "self_rating_question_sequence", sequenceName = "self_rating_question_sequence")
    private Integer id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "numOptions")
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
        SelfRatingQuestionEntity that = (SelfRatingQuestionEntity) o;
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
        return "SelfRatingQuestionEntity{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", numOptions=" + numOptions +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
