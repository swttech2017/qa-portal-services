package com.qa.portal.selfreflection.persistence.entity;

import com.qa.portal.common.persistence.entity.QaBaseEntity;
import com.qa.portal.common.persistence.entity.QaUserEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema="training", name="qa_user_self_reflection_form")
public class SelfReflectionFormEntity extends QaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_user_self_reflection_form_sequence")
    @SequenceGenerator(name = "qa_user_self_reflection_form_sequence", sequenceName = "training.qa_user_self_reflection_form_sequence")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "qa_user_id")
    private QaUserEntity qaUser;

    @OneToMany(mappedBy = "qaUserSelfReflectionForm", cascade = CascadeType.ALL)
    private List<SelfReflectionFormStatusEntity> qaUserSelfReflectionFormStatuses;

    @OneToMany(mappedBy = "qaUserSelfReflectionForm", cascade = CascadeType.ALL)
    private List<SelfReflectionReviewEntity> selfReflectionReviews;

    @OneToMany(mappedBy = "qaUserSelfReflectionForm", cascade = CascadeType.ALL)
    private List<SelfRatingEntity> selfRatings;

    @Column(name="strengths_text")
    private String strengthsText;

    @Column(name="weaknesses_text")
    private String weaknessesText;

    @Column(name="opportunities_text")
    private String opportunitiesText;

    @Column(name="threats_text")
    private String threatsText;

    @Column(name="week_commencing")
    private Date weekCommencing;

    @Transient
    private String currentStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QaUserEntity getQaUser() {
        return qaUser;
    }

    public void setQaUser(QaUserEntity qaUser) {
        this.qaUser = qaUser;
    }

    public String getStrengthsText() {
        return strengthsText;
    }

    public void setStrengthsText(String strengthsText) {
        this.strengthsText = strengthsText;
    }

    public String getWeaknessesText() {
        return weaknessesText;
    }

    public void setWeaknessesText(String weaknessesText) {
        this.weaknessesText = weaknessesText;
    }

    public String getOpportunitiesText() {
        return opportunitiesText;
    }

    public void setOpportunitiesText(String opportunitiesText) {
        this.opportunitiesText = opportunitiesText;
    }

    public String getThreatsText() {
        return threatsText;
    }

    public void setThreatsText(String threatsText) {
        this.threatsText = threatsText;
    }

    public Date getWeekCommencing() {
        return weekCommencing;
    }

    public void setWeekCommencing(Date weekCommencing) {
        this.weekCommencing = weekCommencing;
    }

    public List<SelfReflectionFormStatusEntity> getQaUserSelfReflectionFormStatuses() {
//        if (qaUserSelfReflectionFormStatuses == null) {
//            qaUserSelfReflectionFormStatuses = Collections.emptyList();
//        }
        return qaUserSelfReflectionFormStatuses;
    }

    public void setQaUserSelfReflectionFormStatuses(List<SelfReflectionFormStatusEntity> qaUserSelfReflectionFormStatuses) {
        this.qaUserSelfReflectionFormStatuses = qaUserSelfReflectionFormStatuses;
    }

    public List<SelfReflectionReviewEntity> getSelfReflectionReviews() {
//        if (selfReflectionReviews == null) {
//            selfReflectionReviews = Collections.emptyList();
//        }
        return selfReflectionReviews;
    }

    public void setSelfReflectionReviews(List<SelfReflectionReviewEntity> selfReflectionReviews) {
        this.selfReflectionReviews = selfReflectionReviews;
    }

    public List<SelfRatingEntity> getSelfRatings() {
//        if (selfRatings == null) {
//            selfRatings = Collections.emptyList();
//        }
        return selfRatings;
    }

    public void setSelfRatings(List<SelfRatingEntity> selfRatings) {
        this.selfRatings = selfRatings;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfReflectionFormEntity that = (SelfReflectionFormEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(qaUser, that.qaUser) &&
                Objects.equals(qaUserSelfReflectionFormStatuses, that.qaUserSelfReflectionFormStatuses) &&
                Objects.equals(selfReflectionReviews, that.selfReflectionReviews) &&
                Objects.equals(selfRatings, that.selfRatings) &&
                Objects.equals(strengthsText, that.strengthsText) &&
                Objects.equals(weaknessesText, that.weaknessesText) &&
                Objects.equals(opportunitiesText, that.opportunitiesText) &&
                Objects.equals(threatsText, that.threatsText) &&
                Objects.equals(weekCommencing, that.weekCommencing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                qaUser,
                qaUserSelfReflectionFormStatuses,
                selfReflectionReviews,
                selfRatings,
                strengthsText,
                weaknessesText,
                opportunitiesText,
                threatsText,
                weekCommencing);
    }

    @Override
    public String toString() {
        return "SelfReflectionFormEntity{" +
                "id=" + id +
                ", qaUser=" + qaUser +
                ", qaUserSelfReflectionFormStatuses=" + qaUserSelfReflectionFormStatuses +
                ", selfReflectionReviews=" + selfReflectionReviews +
                ", selfRatings=" + selfRatings +
                ", strengthsText='" + strengthsText + '\'' +
                ", weaknessesText='" + weaknessesText + '\'' +
                ", opportunitiesText='" + opportunitiesText + '\'' +
                ", threatsText='" + threatsText + '\'' +
                ", weekCommencing=" + weekCommencing +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
