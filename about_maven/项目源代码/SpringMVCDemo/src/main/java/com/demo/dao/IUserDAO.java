package com.demo.dao;

import java.util.Collection;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.demo.entity.User;
import com.demo.util.Page;

public interface IUserDAO {
	//µÇÂ¼
	public User findUserByCodeAndPwd(@Param("userCode") String userCode,@Param("userPwd") String userPwd);
	//Õ¹Ê¾Ò³Ãæ
	public Collection<User> findAllUser(Map<String,Object> paramMap);
	public Integer findUserCount(Map<String , Object> paramMap);
	//ËÑË÷
	public Integer findUserCondition(Map<String , Object>paramMap);
	public Collection<User> findMutiCondition(Map<String,Object> paramMap);
	
	public Collection<User> findAllUser();
	public Page<User> findAllUsers(Page<User> page,User user);
	public String createCondition(User user);
	public User findUserByUserId(Integer uuId);
	public Integer getMaxUserId();
	
	public void addUser(User user);
	public void editUser(User user);
	public void delUser(String userId);
}

