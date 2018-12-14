package com.ndt.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "orderform", schema = "ndt")
public class OrderEntity implements Serializable {
	private int orderid;
	private int userid;
	private int companyid;
	private int carid;
	private String departure;
	private String destination;
	private Timestamp time;
	private Timestamp deliverytime;
	private Timestamp finishtime;
	private int itemamount;
	private double itemsize;
	private double price;
	private String status;
	private Timestamp availabletime;
	private Timestamp availabletime1;
	private String title;

	@Id
	@Column(name = "orderid", nullable = false)
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	@Basic
	@Column(name = "userid", nullable = false)
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Basic
	@Column(name = "companyid", nullable = false, length = 255)
	public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	@Basic
	@Column(name = "carid", nullable = true)
	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	@Basic
	@Column(name = "departure", nullable = false, length = 255)
	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	@Basic
	@Column(name = "destination", nullable = false, length = 255)
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Basic
	@Column(name = "time", nullable = false)
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Basic
	@Column(name = "deliverytime", nullable = true)
	public Timestamp getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(Timestamp deliverytime) {
		this.deliverytime = deliverytime;
	}

	@Basic
	@Column(name = "finishtime", nullable = true)
	public Timestamp getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(Timestamp finishtime) {
		this.finishtime = finishtime;
	}

	@Basic
	@Column(name = "itemamount", nullable = false)
	public int getItemamount() {
		return itemamount;
	}

	public void setItemamount(int itemamount) {
		this.itemamount = itemamount;
	}

	@Basic
	@Column(name = "itemsize", nullable = false, precision = 0)
	public double getItemsize() {
		return itemsize;
	}

	public void setItemsize(double itemsize) {
		this.itemsize = itemsize;
	}

	@Basic
	@Column(name = "price", nullable = true, precision = 2)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Basic
	@Column(name = "status", nullable = false, length = 255)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic
	@Column(name = "availabletime", nullable = true)
	public Timestamp getAvailabletime() {
		return availabletime;
	}

	public void setAvailabletime(Timestamp availabletime) {
		this.availabletime = availabletime;
	}

	@Basic
	@Column(name = "availabletime1", nullable = true)
	public Timestamp getAvailabletime1() {
		return availabletime1;
	}

	public void setAvailabletime1(Timestamp availabletime1) {
		this.availabletime1 = availabletime1;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
				Objects.equals(availabletime1, that.availabletime1) &&
				Objects.equals(title, that.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderid, userid, companyid, carid, departure, destination, time, deliverytime, finishtime, itemamount, itemsize, price, status, availabletime, availabletime1, title);
	}

	@Override
	public String toString(){
		return " 标题："+title+"orderid:"+orderid+" userid:"+userid+" companyid:"+companyid+" carid:"+carid+" 状态："+status+" 出发地："+departure+" 目的地："+destination+
				" 创建时间："+time+" 派送时间："+deliverytime+" 完成时间："+finishtime+" 数量："+itemamount+" 重量:"+itemsize+" 价格："+price+
				" 期望时间："+availabletime+"~"+availabletime1+" 标题："+title;
	}
}
