package com.ndt.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "ndt", catalog = "")
public class CarEntity {
    private int carid;
    private Integer driverid;
    private Integer companyid;
    private String kind;
    private String number;

    @Id
    @Column(name = "carid")
    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    @Basic
    @Column(name = "driverid")
    public Integer getDriverid() {
        return driverid;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    @Basic
    @Column(name = "companyid")
    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    @Basic
    @Column(name = "kind")
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return carid == carEntity.carid &&
                Objects.equals(driverid, carEntity.driverid) &&
                Objects.equals(companyid, carEntity.companyid) &&
                Objects.equals(kind, carEntity.kind) &&
                Objects.equals(number, carEntity.number);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carid, driverid, companyid, kind, number);
    }
}
