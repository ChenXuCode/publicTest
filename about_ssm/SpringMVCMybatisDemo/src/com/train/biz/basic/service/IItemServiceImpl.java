package com.train.biz.basic.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.base.page.Page;
import com.train.biz.basic.dao.IItemDAO;
import com.train.biz.basic.entity.Item;
import com.train.security.entity.SysUser;

@Service
public class IItemServiceImpl implements IItemService {

	@Autowired
	private IItemDAO iItemDAO;
	@Override
	public Page<Item> findAllItems(Page<Item> page, Item item) {
		Map<String,Object> paramMap= new HashMap<String,Object>();
		paramMap.put("page", page);
		paramMap.put("item", item);
		//封装Page对象的总记录数
		page.paginationProcess((long)iItemDAO.findItemCount());
		//当前页的记录集
		Collection<Item> itemList= iItemDAO.findAllItems(paramMap);
		page.setPageResult(itemList);
		return page;
	}
	
	@Override
	public Page<Item> findMutiCondition(Page<Item> page, Item item) {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap= new HashMap<String,Object>();
		paramMap.put("page", page);
		paramMap.put("item", item);
		System.out.println(item.getItemCode().toString());
		System.out.println(iItemDAO.findItemCountByCondition(item).toString());
		//封装Page对象的总记录数
		page.paginationProcess((long)iItemDAO.findItemCountByCondition(item));  
		//当前页的记录集
		Collection<Item> itemList= iItemDAO.findMutiCondition(paramMap);
		for (Item item1 :itemList){
			System.out.println(item1.getItemName().toString());
		}
		page.setPageResult(itemList);
		return page;
	}

	@Override
	public void addItem(Item item) {
		item.setItemId(this.findItemMaxItemId());
		iItemDAO.addItem(item);
	}

	@Override
	public Integer findItemMaxItemId() {
		return iItemDAO.findItemMaxItemId();
	}

	/*
	 * 更新物料
	 * */
	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println("******************************************updateItem*****************************************");
		System.out.println("editSaveItem= "+item.toString());
		System.out.println("******************************************updateItem*****************************************");
		iItemDAO.updateItemById(item);
	}



	@Override
	public Item findItemByItemId(String ItemId) {
		// TODO Auto-generated method stub
		return iItemDAO.findItemByItemId(ItemId);
	}

	@Override
	public void deleteUser(Integer itemId) {
		// TODO Auto-generated method stub
		iItemDAO.deleteItemById(itemId);
	}

}
