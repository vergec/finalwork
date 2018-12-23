package com.ndt.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Component
@Entity
@Table(name = "user", schema = "ndt")
public class UserEntity implements Serializable {
	private int userid;
	private String loginname;
	private String secret;
	private String username;
	private String phone;
	private String sex;
	private String email;
	private String img;

	@Column(name = "img",nullable = true)
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "loginname")
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Basic
    @Column(name = "secret")
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userid == that.userid &&
                Objects.equals(loginname, that.loginname) &&
                Objects.equals(secret, that.secret) &&
                Objects.equals(username, that.username) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(email, that.email) &&
                Objects.equals(img, that.img);
    }

	@Override
	public int hashCode() {
		return Objects.hash(userid, loginname, secret, username, phone, sex, email);
	}

	@Override
	public String toString() {
		return "userid:"+userid+" username:"+username+" loginname:"+loginname+" secret:"+secret+" phone:"+phone+" sex:"+sex+" email:"+email+" img:"+img;
	}
}
