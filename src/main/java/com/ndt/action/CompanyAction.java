package com.ndt.action;

import com.ndt.entity.CompanyEntity;
import com.ndt.service.CompanyService;

public class CompanyAction {
    private CompanyEntity companyEntity;
    private CompanyService companyService;

    public String list(){
        companyEntity=companyService.listCompanyEntity();
        return "list";
    }
    public String update(){
        companyService.updateCompany(companyEntity);
        return "update";
    }
    public String adminUpdate(){
        companyService.updateCompany(companyEntity);
        return "adminUpdate";
    }
    public String delete(){
        companyService.deleteCompany(companyEntity.getCompanyid());
        return "delete";
    }
    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
