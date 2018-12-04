package com.ndt.action;

import com.ndt.dao.impl.CompanyDAOImpl;
import com.ndt.entity.EmployeeEntity;
import com.ndt.service.CompanyService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name = "listEmployeeEntities", location = "company/showEmployee.jsp"),
        @Result(name = "show", type = "redirect", location = "show"),
        @Result(name = "error", location = "/fail.jsp")})
public class CompanyAction {
    private List<EmployeeEntity> employeeEntities;
    private EmployeeEntity employeeEntity;

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

    @Autowired
    private CompanyService companyService;

    public CompanyAction() {
    }

    @Action("show")
    public String listEmployeeEntities(){
        employeeEntities=companyService.listEmployeeEntities();
        return "listEmployeeEntities";
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }
}
