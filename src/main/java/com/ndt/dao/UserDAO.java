package com.ndt.dao;

import com.ndt.entity.UserEntity;

import java.util.List;

public interface UserDAO extends IBaseDAO<UserEntity,Integer>{

	UserEntity creatUser(UserEntity userEntity);

	void updateUser(UserEntity userEntity);

	void deleteUser(UserEntity userEntity);

	UserEntity findUserById(Integer id);

	UserEntity findUserByName(String username);

	List<UserEntity> findUsersByName(String username);

	List<UserEntity> findAllUser();


}
