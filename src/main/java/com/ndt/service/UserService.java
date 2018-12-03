package com.ndt.service;

import com.ndt.dao.UserDAO;
import com.ndt.entity.UserEntity;

import javax.annotation.Resource;
import java.util.List;

public class UserService {
	@Resource(name = "userDAO")
	UserDAO userDAO;
	public void deleteUser(UserEntity userEntity){
		userDAO.delete(userEntity.getUserid());
	}
	public void updateUser(UserEntity userEntity){
		userDAO.update(userEntity);
	}
	public boolean isNameExist(int id){
		return userDAO.findById(id) != null;
	}
	public UserEntity getUser(UserEntity userEntity){
		return userDAO.findByHql("from UserEntity as user where loginname ='"+userEntity.getLoginname()+"'");
	}

	public UserEntity getUser(int id){
		return userDAO.findById(id);
	}
	public List<UserEntity> getAllUser(){
		return userDAO.findAll();
	}
}
