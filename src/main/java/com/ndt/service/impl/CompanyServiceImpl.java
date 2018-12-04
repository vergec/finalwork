package com.ndt.service.impl;

import com.ndt.dao.CompanyDAO;
import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EmployeeEntity;
import com.ndt.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDAO companyDAO;

    @Override
    public List<EmployeeEntity> listEmployeeEntities() {
        return companyDAO.findAllEmployee();
    }

    public int login(CompanyEntity companyEntity){
        return companyDAO.login(companyEntity);
    }

    public boolean register(CompanyEntity companyEntity){
        return companyDAO.register(companyEntity);
    }

    public CompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
}
