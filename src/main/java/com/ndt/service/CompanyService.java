package com.ndt.service;

import com.ndt.entity.CarEntity;
import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EmployeeEntity;
import com.ndt.entity.EvaluationEntity;

import java.util.List;

public interface CompanyService {
    List<EmployeeEntity> listEmployeeEntities();
    List<CarEntity> listCarEntities();
    List<CompanyEntity> listCompanyEntities();
    CompanyEntity listCompanyEntity();
	CompanyEntity findCompanyEntity(int id);
    int login(CompanyEntity companyEntity);
    boolean register(CompanyEntity companyEntity);
    void deleteCompany(Integer id);
    void deleteCar(Integer id);
    void deleteEmployee(Integer id);
    void updateEmployee(EmployeeEntity employeeEntity);
    void updateCar(CarEntity carEntity);
    void updateCompany(CompanyEntity companyEntity);
    void addEmployee(EmployeeEntity employeeEntity);
    void addCar(CarEntity carEntity);
    EvaluationEntity queryEvaluation(int orderId);
    List<EvaluationEntity> queryAllEvaluation(int companyId);
}
