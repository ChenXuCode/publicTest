package com.train.biz.basic.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.train.biz.basic.entity.Item;
import com.train.biz.basic.entity.Stu;

public interface StudentDAO {
   //创建接口方法,不含实现类,实现通过mybatis配置文件
	public List<Stu> selectByExampleWithPro();
	public Collection<Item> findAllStudent(Map<String,Object> paramMap);
}
