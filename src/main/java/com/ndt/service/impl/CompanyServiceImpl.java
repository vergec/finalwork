package com.ndt.service.impl;

import com.ndt.dao.CompanyDAO;
import com.ndt.dao.EvaluationDAO;
import com.ndt.entity.CarEntity;
import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EmployeeEntity;
import com.ndt.entity.EvaluationEntity;
import com.ndt.service.CompanyService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
//@Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
public class CompanyServiceImpl implements CompanyService {
    private CompanyDAO companyDAO;
	private EvaluationDAO evaluationDAO;
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

	@Override
	public EvaluationEntity queryEvaluation(int orderId) {
		return evaluationDAO.getOrderEvaluation(orderId);
	}

	@Override
	public List<EvaluationEntity> queryAllEvaluation(int companyId) {
		return evaluationDAO.getCompanyEvaluation(companyId);
	}

	public CompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

	public EvaluationDAO getEvaluationDAO() {
		return evaluationDAO;
	}

	public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}
}
