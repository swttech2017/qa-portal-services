package com.qa.portal.selfreflection.dto;

import java.util.Objects;

public class SelfReflectionStatusDto {

    private Integer id;

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
        SelfReflectionStatusDto that = (SelfReflectionStatusDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(statusText, that.statusText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusText);
    }

    @Override
    public String toString() {
        return "SelfReflectionStatusDto{" +
                "id=" + id +
                ", statusText='" + statusText + '\'' +
                '}';
    }
}
