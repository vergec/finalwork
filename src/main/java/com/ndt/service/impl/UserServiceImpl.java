package com.ndt.service.impl;

import com.ndt.dao.EvaluationDAO;
import com.ndt.dao.UserDAO;
import com.ndt.entity.EvaluationEntity;
import com.ndt.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements com.ndt.service.UserService {

	private final UserDAO userDAO;
	private final EvaluationDAO evaluationDAO;

	@Autowired
	public UserServiceImpl(UserDAO userDAO, EvaluationDAO evaluationDAO) {
		this.userDAO = userDAO;
		this.evaluationDAO = evaluationDAO;
	}

	public void deleteUser(UserEntity userEntity) {
		userDAO.delete(userEntity);
	}

	public UserEntity creatUser(UserEntity userEntity) {
		return userDAO.creatUser(userEntity);
	}

	public void updateUser(UserEntity userEntity) {
		userDAO.update(userEntity);
	}

	public boolean isUserExist(int id) {
		return userDAO.findById(id)!=null;
	}

	public boolean isNameExist(UserEntity userEntity) {
		return getUserByName(userEntity) != null;
	}

	public UserEntity getUserByName(UserEntity userEntity) {
		return userDAO.findUserByName(userEntity.getLoginname());
	}

	public UserEntity getUserById(int id) {
		return userDAO.findById(id);
	}

	public List<UserEntity> getAllUser() {
		return userDAO.findAll();
	}

	@Override
	public EvaluationEntity addUserEvaluation(int userId, EvaluationEntity evaluationEntity) {
		evaluationEntity.setUserid(userId);
		return evaluationDAO.insertEvaluation(evaluationEntity);
	}

	@Override
	public List<EvaluationEntity> getUserEvaluation(int userId) {
		return evaluationDAO.getUserEvaluation(userId);
	}

	@Override
	public EvaluationEntity queryEvaluation(int orderId) {
		return evaluationDAO.getOrderEvaluation(orderId);
	}

	public UserEntity register (UserEntity userEntity) {
		if(isNameExist(userEntity)){
			return null;
		} else {
			return userDAO.create(userEntity);
		}
	}
}
