package com.train.biz.basic.service;

import com.train.base.page.Page;
import com.train.biz.basic.entity.Item;
import com.train.security.entity.SysUser;

public interface IItemService {
  public Page<Item> findAllItems(Page<Item> page,Item item);
  public Page<Item> findMutiCondition(Page<Item> page,Item item); 
  public void addItem(Item item);
  public Integer findItemMaxItemId();
  public void updateItem(Item item);
  public Item findItemByItemId(String ItemId);
  public void deleteUser(Integer itemId);
}
