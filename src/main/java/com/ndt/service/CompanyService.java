package com.ndt.service;

import com.ndt.entity.CarEntity;
import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EmployeeEntity;

import java.util.List;

public interface CompanyService {
    List<EmployeeEntity> listEmployeeEntities();
    List<CarEntity> listCarEntities();
    CompanyEntity listCompanyEntities();
    int login(CompanyEntity companyEntity);
    boolean register(CompanyEntity companyEntity);
    void deleteCar(Integer id);
    void deleteEmployee(Integer id);
    void updateEmployee(EmployeeEntity employeeEntity);
    void updateCar(CarEntity carEntity);
    void updateCompany(CompanyEntity companyEntity);
    void addEmployee(EmployeeEntity employeeEntity);
    void addCar(CarEntity carEntity);
}
