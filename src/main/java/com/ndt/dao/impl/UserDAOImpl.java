package com.ndt.dao.impl;

import com.ndt.dao.AGenericHibernateDao;
import com.ndt.dao.UserDAO;
import com.ndt.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("useDAO")
public class UserDAOImpl extends AGenericHibernateDao<UserEntity,Integer> implements UserDAO {

	@Override
	public void deleteUser(UserEntity userEntity) {
		super.delete(userEntity);
	}

	@Override
	public UserEntity findUserById(Integer id) {
		return super.findById(id);
	}

	@Override
	public List<UserEntity> findUsersByName(String username) {
		String strHQL = "from UserEntity as user where loginname='"+username+"'";
		return super.findByHQL(strHQL);
	}

	@Override
	public List<UserEntity> findAllUser() {
		return null;
	}

	@Override
	public UserEntity findUserByName(String username) {
		String strHQL = "from UserEntity as user where loginname='"+username+"'";
		return super.findByHql(strHQL);
	}

	@Override
	public UserEntity creatUser(UserEntity userEntity) {
		return super.create(userEntity);
	}

	@Override
	public void updateUser(UserEntity userEntity) {
		super.update(userEntity);
	}
}
