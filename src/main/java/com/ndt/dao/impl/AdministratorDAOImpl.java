package com.ndt.dao.impl;

import com.ndt.dao.AdministratorDAO;
import com.ndt.entity.AdministratorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


public class AdministratorDAOImpl implements AdministratorDAO {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean login(AdministratorEntity administratorEntity) {
		String hql = "from AdministratorEntity as admin where loginname = '"+administratorEntity.getLoginname()+"'";
		Session s = sessionFactory.openSession();
		Query query = s.createQuery(hql);
		List list = query.list();
		for(Object a:list){
			AdministratorEntity b = (AdministratorEntity) a;
			if(b.getSecret().equals(administratorEntity.getSecret())){
				s.close();
				return true;
			}
		}
		s.close();
		return false;
	}
}
