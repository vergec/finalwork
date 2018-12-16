package com.ndt.service.impl;

import com.ndt.dao.CompanyDAO;
import com.ndt.entity.CarEntity;
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

    @Override
    public List<CarEntity> listCarEntities() {
        return companyDAO.findAllCar();
    }

	@Override
	public List<CompanyEntity> listCompanyEntities() {
		return companyDAO.showAllCompany();
	}

	@Override
    public CompanyEntity listCompanyEntity() {
        return companyDAO.showCompany();
    }

	@Override
	public CompanyEntity findCompanyEntity(int id) {
		return companyDAO.findCompany(id);
	}

	public int login(CompanyEntity companyEntity){
        return companyDAO.login(companyEntity);
    }

    public boolean register(CompanyEntity companyEntity){
        return companyDAO.register(companyEntity);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyDAO.deleteCompany(companyDAO.findCompanyEntityById(id));
    }

    @Override
    public void deleteCar(Integer id) {
        companyDAO.deleteCar(companyDAO.findCarById(id));
    }

    @Override
    public void deleteEmployee(Integer id) {
        companyDAO.deleteEmployee(companyDAO.findEmployeeById(id));
    }

    @Override
    public void updateEmployee(EmployeeEntity employeeEntity) {
        companyDAO.updateEmployee(employeeEntity);
    }

    @Override
    public void updateCar(CarEntity carEntity) {
        companyDAO.updateCar(carEntity);
    }

    @Override
    public void updateCompany(CompanyEntity companyEntity) {
        companyDAO.updateCompany(companyEntity);
    }

    @Override
    public void addEmployee(EmployeeEntity employeeEntity) {
        companyDAO.addEmployee(employeeEntity);
    }

    @Override
    public void addCar(CarEntity carEntity) {
        companyDAO.addCar(carEntity);
    }

    public CompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
}
