package com.qa.portal.selfreflection.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qa.portal.common.persistence.entity.QaBaseEntity;
import com.qa.portal.common.persistence.entity.QaUserEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema="training", name="qa_user_self_reflection_form_status")
public class SelfReflectionFormStatusEntity extends QaBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_user_self_reflection_form_status_sequence")
    @SequenceGenerator(name = "qa_user_self_reflection_form_status_sequence", sequenceName = "qa_user_self_reflection_form_status_sequence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "qa_user_self_reflection_form_id")
    @JsonIgnore
    private SelfReflectionFormEntity qaUserSelfReflectionForm;

    @ManyToOne
    @JoinColumn(name = "self_reflection_status_id")
    private SelfReflectionStatusEntity selfReflectionStatus;

    @ManyToOne
    @JoinColumn(name = "qa_user_id")
    private QaUserEntity updatingUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SelfReflectionFormEntity getQaUserSelfReflectionForm() {
        return qaUserSelfReflectionForm;
    }

    public void setQaUserSelfReflectionForm(SelfReflectionFormEntity qaUserSelfReflectionForm) {
        this.qaUserSelfReflectionForm = qaUserSelfReflectionForm;
    }

    public SelfReflectionStatusEntity getSelfReflectionStatus() {
        return selfReflectionStatus;
    }

    public void setSelfReflectionStatus(SelfReflectionStatusEntity selfReflectionStatus) {
        this.selfReflectionStatus = selfReflectionStatus;
    }

    public QaUserEntity getUpdatingUser() {
        return updatingUser;
    }

    public void setUpdatingUser(QaUserEntity updatingUser) {
        this.updatingUser = updatingUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfReflectionFormStatusEntity that = (SelfReflectionFormStatusEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(qaUserSelfReflectionForm, that.qaUserSelfReflectionForm) &&
                Objects.equals(selfReflectionStatus, that.selfReflectionStatus) &&
                Objects.equals(updatingUser, that.updatingUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qaUserSelfReflectionForm, selfReflectionStatus, updatingUser);
    }

    @Override
    public String toString() {
        return "SelfReflectionFormStatusEntity{" +
                "id=" + id +
                ", selfReflectionStatus=" + selfReflectionStatus +
                ", updatingUser=" + updatingUser +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
