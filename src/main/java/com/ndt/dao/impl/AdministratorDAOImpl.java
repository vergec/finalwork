package com.ndt.dao.impl;

import com.ndt.dao.AdministratorDAO;
import com.ndt.entity.AdministratorEntity;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


public class AdministratorDAOImpl extends HibernateDaoSupport implements AdministratorDAO{

	@Override
	public boolean login(AdministratorEntity administratorEntity) {
		if(this.getHibernateTemplate().findByExample(administratorEntity).size()>0){
			return true;
		}else{
			return false;
		}
	}
}
