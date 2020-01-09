package com.demo.service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.IUserDAO;
import com.demo.entity.User;
import com.demo.util.Page;

@Service
public class IUserServiceImpl implements IUserService {

	protected static final Log log=LogFactory.getLog(IUserServiceImpl.class);
	@Autowired
	private IUserDAO userDao;
	//登录
	@Override
	public boolean UserValidate(HttpServletRequest request, String userCode, String userPwd) {
		// TODO Auto-generated method stub
		if((userDao.findUserByCodeAndPwd(userCode, userPwd)!=null))
		{
			request.getSession().setAttribute("currentUserName", userDao.findUserByCodeAndPwd(userCode, userPwd).getUserName());
			return true;
			
		}else {
			return false;
		}
		
	}
	//展示页面
	@Override
	public Page<User> findAllUser(Page<User> page, User user) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("user",user);
		
		page.paginationProcess((long)userDao.findUserCount(paramMap));
		Collection<User> userList=userDao.findAllUser(paramMap);
		page.setPageResult(userList);
		return page;
	}
	//搜索
	@Override
	public Page<User> findAllUserByCondition(Page<User> page, User user) {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("user", user);
		System.out.println("2"+user.getUserCode());
		page.paginationProcess((long)userDao.findUserCondition(paramMap));
		System.out.println(userDao.findUserCondition(paramMap)+"");
		System.out.println("3");
		Collection<User> userList=userDao.findMutiCondition(paramMap);
		System.out.println("4");
		page.setPageResult(userList);
		return page;
	}
	@Override
	public String createCondition(User user) {
		// TODO Auto-generated method stub
		return userDao.createCondition(user);
	}
	//添加
	@Override
	public void addUser(HttpServletRequest request, User user) {
		user.setCreateUser(request.getSession().getAttribute("currentUserName").toString());
		user.setUpdateUser(request.getSession().getAttribute("currentUserName").toString());
		user.setUserId(Integer.parseInt(userDao.getMaxUserId().toString()));
		user.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		user.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		userDao.addUser(user);
	}
	@Override
	public User findUserById(Integer uuId) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserId(uuId);
	}

	@Override
	public void editUser(Integer uuId, User user) {
		// TODO Auto-generated method stub
		userDao.editUser(user);
		System.out.println("editUser");
	}

	@Override
	public void delUser(String usrId) {
		// TODO Auto-generated method stub
		userDao.delUser(usrId);
	}

	@Override
	public Page<User> findMutiCondition(Page<User> page, User user) {
		// TODO Auto-generated method stub
		//封装成Map
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("user",user);
		//封装Page的总记录数
		page.paginationProcess((long)userDao.findUserCondition(paramMap));
		//当前页的记录集
		Collection<User> userList=userDao.findMutiCondition(paramMap);
		page.setPageResult(userList);
		return page;
	}

}


