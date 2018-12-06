package com.ndt.action;

import com.ndt.entity.AdministratorEntity;
import com.ndt.entity.CompanyEntity;
import com.ndt.service.AdministratorService;
import com.ndt.service.impl.CompanyServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

//@Controller
//@Scope("prototype")
public class LoginAction extends ActionSupport {
    @Resource
    private AdministratorService administratorService;
    private AdministratorEntity administratorEntity;
    private CompanyServiceImpl companyService;
    private CompanyEntity companyEntity;
    @Override
    public String execute() throws Exception {
        System.out.println("executed");
        int companyId=companyService.login(companyEntity);
        if (companyId>0) {
            ActionContext.getContext().getSession().put("companyId", companyId);
            System.out.println(ActionContext.getContext().getSession().get("companyId")+"session测试");
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public void setCompanyService(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    public CompanyServiceImpl getCompanyService() {
        return companyService;
    }
    public AdministratorEntity getAdministratorEntity() {
        return administratorEntity;
    }

    public void setAdministratorEntity(AdministratorEntity administratorEntity) {
        this.administratorEntity = administratorEntity;
    }

    public AdministratorService getAdministratorService() {
        return administratorService;
    }

    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }



}
