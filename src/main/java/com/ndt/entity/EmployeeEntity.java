package com.ndt.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "ndt", catalog = "")
public class EmployeeEntity {
    private int employeeid;
    private int companyid;
    private String name;
    private String position;
    private String phone;

    @Id
    @Column(name = "employeeid")
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Basic
    @Column(name = "companyid")
    public int getCompanyid() {
        return companyid;
    }

    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return employeeid == that.employeeid &&
                companyid == that.companyid &&
                Objects.equals(name, that.name) &&
                Objects.equals(position, that.position) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employeeid, companyid, name, position, phone);
    }
}
