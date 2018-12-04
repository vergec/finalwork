package com.ndt.dao.impl;

import com.ndt.dao.AGenericHibernateDao;
import com.ndt.dao.AdministratorDAO;
import com.ndt.entity.AdministratorEntity;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository("administratorDAO") //进行注入
public class AdministratorDAOImpl extends AGenericHibernateDao<AdministratorEntity,Integer> implements AdministratorDAO {
	@Override
	public List findByHQL(String strHQL) {
		return super.findByHQL(strHQL);
	}
}
