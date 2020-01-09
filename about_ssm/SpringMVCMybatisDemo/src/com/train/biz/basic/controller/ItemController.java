package com.train.biz.basic.controller;

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
import com.train.biz.basic.service.IItemService;
import com.train.security.entity.SysUser;
import com.train.util.ConstantMethod;

@Controller
@RequestMapping("/item.do")
@Scope("prototype")
public class ItemController {

	@Autowired 
	private IItemService iItemService;
	
	@RequestMapping(params = "action=basItemIndex")
	public ModelAndView basItemIndex(HttpServletRequest request,
			ModelMap model, Item item, Long curPage, Long pageRows) throws Exception {
		System.out.println("/item.do/action=basItemIndex");
		if (item.getUseFlag() == null) {
			item.setUseFlag(-2);
		}
		Page<Item> page = new Page<Item>(curPage, pageRows);
		page.setUrl("item.do?action=basItemIndex");
		page = iItemService.findAllItems(page, item);
		model.put("page", page);
		model.put("item", item);
		return new ModelAndView("biz/basic/itemIndex");

	}
	
	@RequestMapping(params = "action=findMutiCondition")
	public ModelAndView findMutiCondition(HttpServletRequest request,
			ModelMap model, Item item, Long curPage, Long pageRows) throws Exception {
		Page<Item> page = new Page<Item>(curPage, pageRows);
		page.setUrl("item.do?action=findMutiCondition");
		page = iItemService.findMutiCondition(page, item);
		model.put("page", page);
		model.put("item", item);
		return new ModelAndView("biz/basic/itemIndex");

	}
	
	/**
	 * 添加物资页面
	 */
	@RequestMapping(params = "action=basItemAdd")
	public ModelAndView basItemAdd(HttpServletRequest request, ModelMap model,
			Long curPage, Long pageRows) throws Exception {
		model.put("curPage", curPage);
		model.put("pageRows", pageRows);
		return new ModelAndView("biz/basic/itemAdd");
	}
	
	/**
	 * 编辑物资页面
	 */
	@RequestMapping(params = "action=ItemEdit")
	public ModelAndView ItemEdit(HttpServletRequest request, ModelMap model,
			String ItemId, Long curPage, Long pageRows) {
		System.out.println("ItemId= "+ItemId);
		model.put("item", iItemService.findItemByItemId(ItemId));
		model.put("curPage", curPage);
		model.put("pageRows", pageRows);
		return new ModelAndView("biz/basic/itemEdit");
	}

	
	/**
	 * 编辑物资
	 */
	@RequestMapping(params = "action=editSaveItem")
	public JsonView editSaveItem(HttpServletRequest request, ModelMap model,
			Long curPage, Long pageRows, Item item) throws Exception {
		JsonView view = new JsonView();
		System.out.println("editSaveItem= "+item.toString());
		try {
			iItemService.updateItem(item);
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", "error");
		}
		return view;
	}
	
	/**
	 * 保存物资
	 */
	@RequestMapping(params = "action=saveAddItem")
	public JsonView saveSysUser(HttpServletRequest request, ModelMap model,
			Long curPage, Long pageRows, Item item) throws Exception {
		System.out.println("/item.do/action=saveAddItem");

		JsonView view = new JsonView();
		try {
			System.out.println(item.toString());
			iItemService.addItem(item);
			
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			ex.printStackTrace();
			view.setProperty("result", "error");
		}
		return view;
	}

	/**
	 * 删除物料
	 */
	@RequestMapping(params = "action=deleteItem")
	public JsonView deleteItem(HttpServletRequest request, ModelMap model,
			Integer ItemCode, Long curPage, Long pageRows) throws Exception {
		JsonView view = new JsonView();
		try {
			System.out.println("deleteItem = "+ItemCode);
			iItemService.deleteUser(ItemCode);
			System.out.println("deleteUser OK");
			view.setProperty("result", "succ");
		} catch (Exception ex) {
			view.setProperty("result", "error");
		}
		return view;
	}
	
}
