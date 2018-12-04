package com.ndt.service;

import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EmployeeEntity;

import java.util.List;

public interface CompanyService {
    List<EmployeeEntity> listEmployeeEntities();
    int login(CompanyEntity companyEntity);
    boolean register(CompanyEntity companyEntity);
}
