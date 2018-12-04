package com.ndt.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "evaluation", schema = "ndt", catalog = "")
public class EvaluationEntity {
    private int evaluationid;
    private int userid;
    private int companyid;
    private int orderid;
    private Timestamp time;
    private String title;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;

    @Id
    @Column(name = "evaluationid")
    public int getEvaluationid() {
        return evaluationid;
    }

    public void setEvaluationid(int evaluationid) {
        this.evaluationid = evaluationid;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "photo1")
    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    @Basic
    @Column(name = "photo2")
    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    @Basic
    @Column(name = "photo3")
    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationEntity that = (EvaluationEntity) o;
        return evaluationid == that.evaluationid &&
                userid == that.userid &&
                companyid == that.companyid &&
                orderid == that.orderid &&
                Objects.equals(time, that.time) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(photo1, that.photo1) &&
                Objects.equals(photo2, that.photo2) &&
                Objects.equals(photo3, that.photo3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(evaluationid, userid, companyid, orderid, time, title, content, photo1, photo2, photo3);
    }
}
