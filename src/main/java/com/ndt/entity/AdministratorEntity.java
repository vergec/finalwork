package com.ndt.entity;

import javax.persistence.*;

@Entity
@Table(name = "administrator", schema = "ndt", catalog = "")
public class AdministratorEntity {
	private int adminid;
	private String loginname;
	private String secret;

	@Id
	@Column(name = "adminid", nullable = false)
	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	@Basic
	@Column(name = "loginname", nullable = false, length = 255)
	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	@Basic
	@Column(name = "secret", nullable = false, length = 255)
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AdministratorEntity that = (AdministratorEntity) o;

		if (adminid != that.adminid) return false;
		if (loginname != null ? !loginname.equals(that.loginname) : that.loginname != null) return false;
		if (secret != null ? !secret.equals(that.secret) : that.secret != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = adminid;
		result = 31 * result + (loginname != null ? loginname.hashCode() : 0);
		result = 31 * result + (secret != null ? secret.hashCode() : 0);
		return result;
	}
}
