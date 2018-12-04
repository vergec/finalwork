package com.ndt.action;

import com.ndt.entity.CompanyEntity;
import com.ndt.service.impl.CompanyServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
    String loginname;
    String password;
    String name;
    String phone;
    String email;
    private CompanyServiceImpl companyService;
    private CompanyEntity companyEntity;
    @Override
    public String execute() throws Exception {
        companyEntity=new CompanyEntity();
        companyEntity.setLoginname(loginname);
        companyEntity.setSecret(password);
        companyEntity.setCompanyname(name);
        companyEntity.setPhone(phone);
        companyEntity.setEmail(email);
        if(companyService.register(companyEntity)){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public CompanyServiceImpl getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
