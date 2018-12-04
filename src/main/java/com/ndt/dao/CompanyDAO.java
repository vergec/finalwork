package com.ndt.dao;

import com.ndt.entity.CarEntity;
import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EmployeeEntity;

import java.util.List;

public interface CompanyDAO {
    int login(CompanyEntity companyEntity);
    boolean register(CompanyEntity companyEntity);
    boolean addEmployee(EmployeeEntity employeeEntity);
    boolean addCar(CarEntity carEntity);
    List<CompanyEntity> showCompanyEvaluation();
    CompanyEntity showCompany();
    List<EmployeeEntity> findAllEmployee();
    CarEntity findAllCar();
    boolean deleteCar(CarEntity carEntity);
    boolean deleteEmployee(EmployeeEntity employeeEntity);
    boolean updateCar(CarEntity carEntity);
    boolean updateEmployee(EmployeeEntity employeeEntity);
    boolean updateCompany(CompanyEntity companyEntity);
}
