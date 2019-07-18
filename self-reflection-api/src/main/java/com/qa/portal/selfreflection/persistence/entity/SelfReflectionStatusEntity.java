package com.qa.portal.selfreflection.persistence.entity;

import com.qa.portal.common.persistence.entity.QaBaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema="training", name="self_reflection_status")
public class SelfReflectionStatusEntity extends QaBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "self_reflection_status_sequence")
    @SequenceGenerator(name = "self_reflection_status_sequence",
            sequenceName = "training.self_reflection_status_sequence",
            allocationSize=1)
    private Integer id;

    @Column(name="status_text")
    private String statusText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfReflectionStatusEntity that = (SelfReflectionStatusEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(statusText, that.statusText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusText);
    }

    @Override
    public String toString() {
        return "SelfReflectionStatusEntity{" +
                "id=" + id +
                ", statusText='" + statusText + '\'' +
                ", lastUpdatedTimestamp=" + lastUpdatedTimestamp +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                '}';
    }
}
