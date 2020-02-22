package com.example.test.dao;

import com.example.test.model.userModel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/*
 * userMapper
 * author: jananadi
 */

public interface userMapper{
	
	void insertUser(userModel model);
	
	void updateUser(userModel model);
	
	void deleteUser(@Param("userId") int userId);
	
	List<userModel> getUserList();
	
	void getUserInfo(@Param("userId") int userId);
	
	
	
}