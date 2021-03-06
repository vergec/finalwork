package com.ndt.dao.impl;

import com.ndt.dao.CompanyDAO;

import com.ndt.entity.CarEntity;
import com.ndt.entity.CompanyEntity;
import com.ndt.entity.EmployeeEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@javax.transaction.Transactional
public class CompanyDAOImpl extends HibernateDaoSupport implements CompanyDAO {
    static int companyId;

    @Override
    public int login(CompanyEntity companyEntity) {
        if(this.getHibernateTemplate().findByExample(companyEntity).size()>0){
            companyId=getHibernateTemplate().findByExample(companyEntity).get(0).getCompanyid();
            return companyId;
        }else{
            return 0;
        }
    }
    //增加
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean register(CompanyEntity companyEntity) {
        System.out.println(companyEntity.getLoginname());
        this.getHibernateTemplate().save(companyEntity);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean addEmployee(EmployeeEntity employeeEntity) {
        employeeEntity.setCompanyid(companyId);
        this.getHibernateTemplate().save(employeeEntity);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean addCar(CarEntity carEntity) {
        carEntity.setCompanyid(companyId);
        this.getHibernateTemplate().save(carEntity);
        return true;
    }
    //查找
	@Override
	public List<CompanyEntity> showAllCompany() {
		return (List<CompanyEntity>) this.getHibernateTemplate().find("from CompanyEntity");
	}


	@Override
    public CompanyEntity showCompany() {
        return this.getHibernateTemplate().get(CompanyEntity.class,companyId);
    }

	@Override
	public CompanyEntity findCompany(int id) {
		return (CompanyEntity)this.getHibernateTemplate().find("from CompanyEntity where companyid="+id).get(0);
	}

	@Override
    public List<EmployeeEntity> findAllEmployee() {

        return (List<EmployeeEntity>)
                this.getHibernateTemplate().find("from EmployeeEntity where companyid="+companyId);
    }

    @Override
    public List<CarEntity> findAllCar() {
        return (List<CarEntity>) this.getHibernateTemplate().find("from CarEntity where companyid="+companyId);
    }

    @Override
    public CompanyEntity findCompanyEntityById(Integer id) {
        List CompanyEntities= this.getHibernateTemplate().find("from CompanyEntity c where c.companyid="+id);
        if(CompanyEntities.size() == 0){
            return null;
        }
        return (CompanyEntity) CompanyEntities.get(0);
    }

    //查找by id
    @Override
    public EmployeeEntity findEmployeeById(Integer id) {
        List employeeEntities= this.getHibernateTemplate().find("from EmployeeEntity e where e.employeeid="+id);
        if(employeeEntities.size() == 0){
            return null;
        }
        return (EmployeeEntity) employeeEntities.get(0);
    }

    @Override
    public CarEntity findCarById(Integer id) {
        List carEntitys=this.getHibernateTemplate().find("from CarEntity c where c.carid="+id);
        if(carEntitys.size() == 0){
            return null;
        }
        return (CarEntity) carEntitys.get(0);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteCar(CarEntity carEntity) {
        this.getHibernateTemplate().delete(carEntity);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteEmployee(EmployeeEntity employeeEntity) {
        this.getHibernateTemplate().delete(employeeEntity);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteCompany(CompanyEntity companyEntity) {
        this.getHibernateTemplate().delete(companyEntity);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateCar(CarEntity carEntity) {
        carEntity.setCompanyid(companyId);
        this.getHibernateTemplate().update(carEntity);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateEmployee(EmployeeEntity employeeEntity) {
        employeeEntity.setCompanyid(companyId);
        this.getHibernateTemplate().update(employeeEntity);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateCompany(CompanyEntity companyEntity) {
        this.getHibernateTemplate().update(companyEntity);
        return true;
    }
}
