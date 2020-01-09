package com.train.biz.basic.dao;

import java.util.Collection;
import java.util.Map;

import com.train.biz.basic.entity.Item;

public interface IItemDAO {
   //创建接口方法,不含实现类,实现通过mybatis配置文件
   public Collection<Item> findAllItems(Map<String,Object> paramMap);
   public Collection<Item> findMutiCondition(Map<String,Object> paramMap);
   public Integer findItemCount();
   public Integer findItemCountByCondition(Item item);
   public void addItem(Item item);
   public Item findItemByItemId(String ItemId);
   public Integer findItemMaxItemId();
   public void updateItemById(Item item);
   public void deleteItemById(Integer itemId);
   public Item findItemById(Integer itemId);
}
