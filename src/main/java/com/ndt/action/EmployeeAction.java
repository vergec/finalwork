package com.ndt.action;

import com.ndt.dao.impl.CompanyDAOImpl;
import com.ndt.entity.EmployeeEntity;
import com.ndt.service.CompanyService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class EmployeeAction extends ActionSupport {
    private List<EmployeeEntity> employeeEntities;
    private EmployeeEntity employeeEntity;
    private CompanyService companyService;

    public String list(){
        employeeEntities=companyService.listEmployeeEntities();
        return "list";
    }

    public String delete(){
        companyService.deleteEmployee(employeeEntity.getEmployeeid());
        return "delete";
    }

    public String update(){
        companyService.updateEmployee(employeeEntity);
        return "update";
    }

    public String add(){
        companyService.addEmployee(employeeEntity);
        return "add";
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }
}
