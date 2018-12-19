package com.ndt.service;

import com.ndt.entity.EvaluationEntity;
import com.ndt.entity.UserEntity;

import java.util.List;

public interface UserService {
	//删除用户
	void deleteUser(UserEntity userEntity);
	//增加用户
	UserEntity creatUser(UserEntity userEntity);
	//更新用户
	UserEntity register(UserEntity userEntity);
	UserEntity updateUser(UserEntity userEntity, UserEntity newUserEntity);
	void updateUser(UserEntity userEntity);
	//检查用户名是否存在
	boolean isUserExist(int id);

	boolean isNameExist(UserEntity userEntity);
	//利用userId查找用户
	UserEntity getUserById(int id);
	//利用用户名查找用户
	UserEntity getUserByName(UserEntity userEntity);
	//获取全部用户
	List<UserEntity> getAllUser();

	EvaluationEntity addUserEvaluation(int userId, EvaluationEntity evaluationEntity);

	List<EvaluationEntity> getUserEvaluation(int userId);

	EvaluationEntity queryEvaluation(int orderId);
}
