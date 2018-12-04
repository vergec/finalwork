package com.ndt.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order", schema = "ndt", catalog = "")
public class OrderEntity {
    private int orderid;
    private int userid;
    private String companyid;
    private Integer carid;
    private String departure;
    private String destination;
    private Timestamp time;
    private Timestamp deliverytime;
    private Timestamp finishtime;
    private int itemamount;
    private double itemsize;
    private BigDecimal price;
    private String status;
    private Timestamp availabletime;
    private Timestamp availabletime1;

    @Id
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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
    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    @Basic
    @Column(name = "carid")
    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    @Basic
    @Column(name = "departure")
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
    @Column(name = "deliverytime")
    public Timestamp getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(Timestamp deliverytime) {
        this.deliverytime = deliverytime;
    }

    @Basic
    @Column(name = "finishtime")
    public Timestamp getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Timestamp finishtime) {
        this.finishtime = finishtime;
    }

    @Basic
    @Column(name = "itemamount")
    public int getItemamount() {
        return itemamount;
    }

    public void setItemamount(int itemamount) {
        this.itemamount = itemamount;
    }

    @Basic
    @Column(name = "itemsize")
    public double getItemsize() {
        return itemsize;
    }

    public void setItemsize(double itemsize) {
        this.itemsize = itemsize;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "availabletime")
    public Timestamp getAvailabletime() {
        return availabletime;
    }

    public void setAvailabletime(Timestamp availabletime) {
        this.availabletime = availabletime;
    }

    @Basic
    @Column(name = "availabletime1")
    public Timestamp getAvailabletime1() {
        return availabletime1;
    }

    public void setAvailabletime1(Timestamp availabletime1) {
        this.availabletime1 = availabletime1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return orderid == that.orderid &&
                userid == that.userid &&
                itemamount == that.itemamount &&
                Double.compare(that.itemsize, itemsize) == 0 &&
                Objects.equals(companyid, that.companyid) &&
                Objects.equals(carid, that.carid) &&
                Objects.equals(departure, that.departure) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(time, that.time) &&
                Objects.equals(deliverytime, that.deliverytime) &&
                Objects.equals(finishtime, that.finishtime) &&
                Objects.equals(price, that.price) &&
                Objects.equals(status, that.status) &&
                Objects.equals(availabletime, that.availabletime) &&
                Objects.equals(availabletime1, that.availabletime1);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderid, userid, companyid, carid, departure, destination, time, deliverytime, finishtime, itemamount, itemsize, price, status, availabletime, availabletime1);
    }
}
