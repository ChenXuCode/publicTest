package com.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.User;
import com.demo.util.Page;

public interface IUserService {
	//µÇÂ¼
	public boolean UserValidate(HttpServletRequest request,String userCode,String userPwd);
	//Õ¹Ê¾Ò³Ãæ
	public Page<User> findAllUser(Page<User> page,User user);
	//ËÑË÷
	public Page<User> findAllUserByCondition(Page<User> page,User user);
	
	public Page<User> findMutiCondition(Page<User> page,User user);
	
	public String createCondition(User user);
	
	
	public void addUser(HttpServletRequest request,User user);
	public User findUserById(Integer uuId);
	public void editUser(Integer uuId,User user);
	public void delUser(String usrId);
}
