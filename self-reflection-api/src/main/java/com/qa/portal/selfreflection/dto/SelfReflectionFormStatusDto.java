package com.qa.portal.selfreflection.dto;

import com.qa.portal.common.dto.QaBaseDto;
import com.qa.portal.common.dto.QaUserDto;

import java.util.Objects;

public class SelfReflectionFormStatusDto extends QaBaseDto {

    private Integer id;

    private SelfReflectionFormDto qaUserSelfReflectionForm;

    private SelfReflectionStatusDto selfReflectionStatus;

    private QaUserDto updatingUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SelfReflectionFormDto getQaUserSelfReflectionForm() {
        return qaUserSelfReflectionForm;
    }

    public void setQaUserSelfReflectionForm(SelfReflectionFormDto qaUserSelfReflectionForm) {
        this.qaUserSelfReflectionForm = qaUserSelfReflectionForm;
    }

    public SelfReflectionStatusDto getSelfReflectionStatus() {
        return selfReflectionStatus;
    }

    public void setSelfReflectionStatus(SelfReflectionStatusDto selfReflectionStatus) {
        this.selfReflectionStatus = selfReflectionStatus;
    }

    public QaUserDto getUpdatingUser() {
        return updatingUser;
    }

    public void setUpdatingUser(QaUserDto updatingUser) {
        this.updatingUser = updatingUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfReflectionFormStatusDto that = (SelfReflectionFormStatusDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(qaUserSelfReflectionForm, that.qaUserSelfReflectionForm) &&
                Objects.equals(selfReflectionStatus, that.selfReflectionStatus) &&
                Objects.equals(updatingUser, that.updatingUser) &&
                Objects.equals(lastUpdatedTimestamp, that.lastUpdatedTimestamp) &&
                Objects.equals(lastUpdatedBy, that.lastUpdatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qaUserSelfReflectionForm, selfReflectionStatus, updatingUser, lastUpdatedTimestamp, lastUpdatedBy);
    }

    @Override
    public String toString() {
        return "SelfReflectionFormStatusDto{" +
                "id=" + id +
                ", selfReflectionStatus=" + selfReflectionStatus +
                ", updatingUser=" + updatingUser +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
