package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.base.JsonView;
import com.demo.entity.User;
import com.demo.service.IUserService;
import com.demo.util.Page;

@Controller
@Scope("prototype")
@RequestMapping("/logon.do")
public class LogonController {
@Autowired
private IUserService userService;
//��¼
@RequestMapping(params="action=logon")
public JsonView logon(HttpServletRequest request,HttpServletResponse response,String userCode,String userPwd,String usrRnd)
{
	System.out.println("1111111111111");
	System.out.println(userCode);
	System.out.println(userPwd);
	JsonView view=new JsonView();
	if(userService.UserValidate(request, userCode, userPwd))
	{
		view.setProperty("result", "succ");
		view.setProperty("message", "����Ajax�ɹ�");
	}else {
		view.setProperty("result", "error");
		view.setProperty("message", "����Ajax�ɹ�,������ֵʧ��");
	}
	return view; 
}
//չʾҳ��
@RequestMapping(params="action=main")
public ModelAndView main(HttpServletRequest request,ModelMap map,Long curPage, Long pageRows,User user)
{
	Page<User> page=new Page<User>(curPage,pageRows);
	page.setUrl("logon.do?action=main");
	
	map.put("page", userService.findAllUser(page, user));
	map.put("user", user);
	return new ModelAndView("main");
	
}
//����
@RequestMapping(params = "action=findMutiCondition")
public ModelAndView findMutiCondition(HttpServletRequest request,
		HttpServletResponse response, ModelMap map, Long curPage,
		Long pageRows, User user) throws Exception {
	// ����һ��page����
	Page<User> page = new Page<User>(curPage, pageRows);
	page.setUrl("logon.do?action=findMutiCondition");
	// ��ȡpage�������Ե�ֵ���
	System.out.println(user.getUserCode()+"user---code"+"����");
	map.put("page", userService.findAllUserByCondition(page, user));
	map.put("user", user);
	System.out.println("1");
	return new ModelAndView("main");

}

//ʵ�������û��Ľ��浯��
	@RequestMapping(params="action=addUser")
	public ModelAndView addUser(HttpServletRequest request,ModelMap map,Long curPage,Long pageRows,User user)throws Exception
	{
		System.out.println("============");
		map.put("curPage", curPage);
		map.put("pageRows", pageRows);
		map.put("status", "0");
		return new ModelAndView("addUser");
	}
	
	//addUserSaveʵ�ֵ����������û��Ľ��汣�水������
	@RequestMapping(params = "action=addUserSave")
	public JsonView addUserSave(HttpServletRequest request,User user)throws Exception
	{
		JsonView view=new JsonView();
		try {
			System.out.println("--------");
			userService.addUser(request, user);
			System.out.println("111"+user.getCreateDate());
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("23442");
			view.setProperty("result", "error");
		}
		return view;
	}
	
	//�༭�û�����
	@RequestMapping(params = "action=editUser")
	public ModelAndView sysUserEdit(HttpServletRequest request,ModelMap model,String uuId,Long curPage,Long pageRows)
	{
		model.put("user",userService.findUserById(Integer.parseInt(uuId)));
		model.put("curPage",curPage);
		model.put("pageRows",pageRows);
		return new ModelAndView("editUser");
	}
	
	//�༭�û�
	@RequestMapping(params = "action=editSaveUser")
	public JsonView editSaveUser(HttpServletRequest request,ModelMap model,Long curPage,Long pageRows,User user)throws Exception
	{
		JsonView view=new JsonView();	
		try {
			System.out.println("�༭�û���");
			userService.editUser(user.getUserId(),user);
			view.setProperty("result", "succ");
			System.out.println("666");
		} catch (Exception e) {
			// TODO: handle exception
			view.setProperty("result","error");
		}
		return view;
	}
	
	//ɾ���û�  delUser
	@RequestMapping(params = "action=delUser")
	public ModelAndView delUser(HttpServletRequest request,ModelMap map,Long curPage,Long pageRows,String uuIds,User user)throws Exception
	{
		System.out.println("ɾ��");
		String uuId=uuIds.substring(0, uuIds.lastIndexOf(","));
		String[] uuIdArr=uuId.split(",");
		for (int i = 0; i < uuIdArr.length; i++) {
			userService.delUser(uuIdArr[i]);
		}
		return this.main(request, map, curPage, pageRows, user);
	//	return new ModelAndView("main");
	}

}
