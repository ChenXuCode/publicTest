package com.train.biz.basic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.train.base.page.Page;
import com.train.base.view.JsonView;
import com.train.biz.basic.entity.Item;
import com.train.biz.basic.entity.Stu;
import com.train.biz.basic.service.IItemService;
import com.train.biz.basic.service.StudentService;
import com.train.security.entity.SysUser;
import com.train.util.ConstantMethod;

@Controller
@RequestMapping("/Myitem.do")
@Scope("prototype")
public class MyItemController {

	@Autowired 
	private StudentService studentService;
	
	@RequestMapping(params = "action=basItemIndex")
	public ModelAndView basItemIndex(HttpServletRequest request,
			ModelMap model, Item item, Long curPage, Long pageRows) throws Exception {
		System.out.println("/item.do/action=basItemIndex");
		List<Stu> stuList = studentService.getAll();
		System.out.println(stuList.size());
		System.out.println(stuList.get(0));
		System.out.println(stuList.get(2));
		return new ModelAndView("biz/basic/TestItemindex");

	}
}
