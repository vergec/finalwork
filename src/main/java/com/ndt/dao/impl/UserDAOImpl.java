package com.ndt.dao.impl;

import com.ndt.dao.AGenericHibernateDao;
import com.ndt.dao.UserDAO;
import com.ndt.entity.UserEntity;

import java.util.List;

public class UserDAOImpl extends AGenericHibernateDao<UserEntity,Integer> implements UserDAO {
	@Override
	public void delete(Integer integer) {
		super.delete(integer);
	}

	@Override
	public UserEntity findById(Integer integer) {
		return super.findById(integer);
	}

	@Override
	public List<UserEntity> findByHQL(String strHQL) {
		return super.findByHQL(strHQL);
	}

	@Override
	public UserEntity findByHql(String strHQL) {
		return super.findByHql(strHQL);
	}

	@Override
	public void update(UserEntity entity) {
		super.update(entity);
	}
}
