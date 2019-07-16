package com.qa.portal.selfreflection.dto;

import com.qa.portal.common.dto.QaUserDto;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class SelfReflectionFormDto {

    private Integer id;

    private QaUserDto qaUser;

    private List<SelfReflectionFormStatusDto> qaUserSelfReflectionFormStatuses;

    private List<SelfReflectionReviewDto> selfReflectionReviews;

    private List<SelfRatingDto> selfRatings;

    private String strengthsText;

    private String weaknessesText;

    private String opportunitiesText;

    private String threatsText;

    private Date weekCommencing;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QaUserDto getQaUser() {
        return qaUser;
    }

    public void setQaUser(QaUserDto qaUser) {
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

    public List<SelfReflectionFormStatusDto> getQaUserSelfReflectionFormStatuses() {
        return qaUserSelfReflectionFormStatuses;
    }

    public void setQaUserSelfReflectionFormStatuses(List<SelfReflectionFormStatusDto> qaUserSelfReflectionFormStatuses) {
        this.qaUserSelfReflectionFormStatuses = qaUserSelfReflectionFormStatuses;
    }

    public List<SelfReflectionReviewDto> getSelfReflectionReviews() {
        return selfReflectionReviews;
    }

    public void setSelfReflectionReviews(List<SelfReflectionReviewDto> selfReflectionReviews) {
        this.selfReflectionReviews = selfReflectionReviews;
    }

    public List<SelfRatingDto> getSelfRatings() {
        return selfRatings;
    }

    public void setSelfRatings(List<SelfRatingDto> selfRatings) {
        this.selfRatings = selfRatings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfReflectionFormDto that = (SelfReflectionFormDto) o;
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
        return "SelfReflectionFormDto{" +
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
                '}';
    }
}
