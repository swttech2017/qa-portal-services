package com.qa.portal.core.dto;

import java.util.List;
import java.util.Objects;

//TODO - This is to be moved to the api-common project

public class QaUser {

    private String userName;

    private List<String> departmentRoles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getDepartmentRoles() {
        return departmentRoles;
    }

    public void setDepartmentRoles(List<String> departmentRoles) {
        this.departmentRoles = departmentRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QaUser qaUser = (QaUser) o;
        return Objects.equals(userName, qaUser.userName) &&
                Objects.equals(departmentRoles, qaUser.departmentRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, departmentRoles);
    }
}
