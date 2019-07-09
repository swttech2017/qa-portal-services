package com.qa.portal.core.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema="training", name="dept_role_application")
public class DepartmentRoleApplicationEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "dept_role_app_sequence", sequenceName = "dept_role_app_sequence")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="app_id")
    private ApplicationEntity application;

    @ManyToOne
    @JoinColumn(name="dept_role_id")
    private DepartmentRoleEntity departmentRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(ApplicationEntity application) {
        this.application = application;
    }

    public DepartmentRoleEntity getDepartmentRole() {
        return departmentRole;
    }

    public void setDepartmentRole(DepartmentRoleEntity departmentRole) {
        this.departmentRole = departmentRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentRoleApplicationEntity that = (DepartmentRoleApplicationEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(application, that.application) &&
                Objects.equals(departmentRole, that.departmentRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, application, departmentRole);
    }

    @Override
    public String toString() {
        return "DepartmentRoleApplicationEntity{" +
                "id=" + id +
                ", application=" + application +
                ", departmentRole=" + departmentRole +
                '}';
    }
}
