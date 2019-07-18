package com.qa.portal.selfreflection.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.portal.common.persistence.entity.QaBaseEntity;
import com.qa.portal.common.persistence.entity.QaUserEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "training", name="self_reflection_review")
public class SelfReflectionReviewEntity extends QaBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "self_reflection_review_sequence")
    @SequenceGenerator(name = "self_reflection_review_sequence", sequenceName = "training.self_reflection_review_sequence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "qa_user_id")
    private QaUserEntity reviewer;

    @ManyToOne
    @JoinColumn(name = "qa_user_self_reflection_form_id")
    @JsonIgnore
    private SelfReflectionFormEntity qaUserSelfReflectionForm;

    @Column(name = "trainer_comments")
    private String trainerComments;

    @Column(name = "learning_pathway")
    private String learningPathway;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QaUserEntity getReviewer() {
        return reviewer;
    }

    public void setReviewer(QaUserEntity reviewer) {
        this.reviewer = reviewer;
    }

    public SelfReflectionFormEntity getQaUserSelfReflectionForm() {
        return qaUserSelfReflectionForm;
    }

    public void setQaUserSelfReflectionForm(SelfReflectionFormEntity qaUserSelfReflectionForm) {
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
        SelfReflectionReviewEntity that = (SelfReflectionReviewEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reviewer, that.reviewer) &&
                Objects.equals(qaUserSelfReflectionForm, that.qaUserSelfReflectionForm) &&
                Objects.equals(trainerComments, that.trainerComments) &&
                Objects.equals(learningPathway, that.learningPathway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewer, qaUserSelfReflectionForm, trainerComments, learningPathway);
    }

    @Override
    public String toString() {
        return "SelfReflectionReviewEntity{" +
                "id=" + id +
                ", reviewer=" + reviewer +
                ", trainerComments='" + trainerComments + '\'' +
                ", learningPathway='" + learningPathway + '\'' +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
