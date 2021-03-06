package com.train.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.train.base.controller.BaseController;
import com.train.base.page.Page;
import com.train.base.view.JsonView;
import com.train.security.entity.SysUser;
import com.train.security.service.ISysUserService;
import com.train.util.ConstantMethod;

/**
 * 业务控制层<br>
 * 
 * 用户管理控制器
 * 
 * @author Tong Baojun
 * 
 */
@Controller
@RequestMapping("/user.do")
@Scope("prototype")
public class SysUserController extends BaseController {
	@Autowired
	private ISysUserService sysUserService;

	/**
	 * 首页
	 */
	@RequestMapping(params = "action=sysUserIndex")
	public ModelAndView sysUserIndex(HttpServletRequest request,
			ModelMap model, SysUser user, Long curPage, Long pageRows)
		
					throws Exception {
		System.out.println("user=   "+user.toString());
		
		if (user.getUserStatus() == null) {
			user.setUserStatus(-2);
		}
		if (user.getUserType() == null) {
			user.setUserType(-2);
		}
		System.out.println("user2=   "+user.toString());
		Page<SysUser> page = new Page<SysUser>(curPage, pageRows);
		page.setUrl("user.do?action=sysUserIndex");
		page = sysUserService.findAllUsers(page, user);
		model.put("page", page);
		model.put("user", user);
		System.out.println("end");
		return new ModelAndView("security/sysUserIndex");

	}

	/**
	 * 添加用户页面
	 */
	@RequestMapping(params = "action=sysUserAdd")
	public ModelAndView sysUserAdd(HttpServletRequest request, ModelMap model,
			Long curPage, Long pageRows) throws Exception {
		model.put("curPage", curPage);
		model.put("pageRows", pageRows);
		model.put("userCode", sysUserService.findUserMaxCode());
		model.put("defaultPwd", ConstantMethod.DEFAULTPWD);
		return new ModelAndView("security/sysUserAdd");
	}

	/**
	 * 保存用户
	 */
	@RequestMapping(params = "action=saveSysUser")
	public JsonView saveSysUser(HttpServletRequest request, ModelMap model,
			Long curPage, Long pageRows, SysUser user) throws Exception {
		JsonView view = new JsonView();
		try {
			sysUserService.saveUser(user);
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			ex.printStackTrace();
			view.setProperty("result", "error");
		}
		return view;
	}

	/**
	 * 编辑用户页面
	 */
	@RequestMapping(params = "action=sysUserEdit")
	public ModelAndView sysUserEdit(HttpServletRequest request, ModelMap model,
			String userCode, Long curPage, Long pageRows) {
		model.put("user", sysUserService.findUserByUserCode(userCode));
		model.put("curPage", curPage);
		model.put("pageRows", pageRows);
		return new ModelAndView("security/sysUserEdit");
	}

	/**
	 * 编辑用户
	 */
	@RequestMapping(params = "action=editSaveUser")
	public JsonView editSaveUser(HttpServletRequest request, ModelMap model,
			Long curPage, Long pageRows, SysUser user) throws Exception {
		JsonView view = new JsonView();
		try {
			sysUserService.updateUser(user.getUuId(), user);
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", "error");
		}
		return view;
	}

	/**
	 * 删除用户
	 */
	@RequestMapping(params = "action=deleteUser")
	public JsonView deleteUser(HttpServletRequest request, ModelMap model,
			String userCode, Long curPage, Long pageRows) throws Exception {
		JsonView view = new JsonView();
		try {
			System.out.println("deluser = "+userCode);
			sysUserService.deleteUser(userCode);
			System.out.println("deleteUser OK");
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", "error");
		}
		return view;
	}

	/**
	 * 分配用户角色
	 */
	@RequestMapping(params = "action=grantUserRoles")
	public JsonView grantUserRoles(HttpServletRequest request, String userCode,
			String roleIds) throws Exception {
		JsonView view = new JsonView();
		try {
			sysUserService.deleteUserRole(userCode);
			sysUserService.saveUserRole(userCode, roleIds);
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", "error");
		}
		return view;
	}

	/**
	 * 重置密码
	 */
	@RequestMapping(params = "action=resetUserPwd")
	public JsonView resetUserPwd(HttpServletRequest request, String userCode)
			throws Exception {
		JsonView view = new JsonView();
		try {
			sysUserService.updateUserPwd(userCode, ConstantMethod.DEFAULTPWD);// 重置后默认密码
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", "error");
		}
		return view;
	}

	@RequestMapping(params = "action=findAllUser")
	public JsonView findAllUser(HttpServletRequest request) throws Exception {
		JsonView view = new JsonView();
		try {
			view.setProperty("usrList", sysUserService.findAllUsers());
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", "error");
		}
		return view;
	}

	/**
	 * 用户密码修改页面
	 */
	@RequestMapping(params = "action=sysUserPwdEdit")
	public ModelAndView sysUserPwdEdit(HttpServletRequest request,
			ModelMap model, Long curPage, Long pageRows) {
		// 获取当前登陆人
		SysUser user = (SysUser) this.getLoginUser(request);
		model.put("user", user);
		return new ModelAndView("security/sysUserPwdEdit");
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(params = "action=updSysUserPwd")
	public JsonView updSysUserPwd(HttpServletRequest request, String userCode,
			String userOldPwd, String userNewPwd) throws Exception {
		JsonView view = new JsonView();
		try {
			// 验证密码是否正确
			boolean flag = sysUserService.invalidPwd(userCode, userOldPwd);
			if (!flag) {
				throw new Exception("旧密码不正确,检查后请重新输入!");
			}
			// 若正确更新密码
			sysUserService.updateUserPwd(userCode, userNewPwd);
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", ex.getMessage());
		}
		return view;
	}
}
