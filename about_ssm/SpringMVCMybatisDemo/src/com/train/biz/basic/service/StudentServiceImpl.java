package com.train.biz.basic.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.biz.basic.dao.StudentDAO;
import com.train.biz.basic.entity.Stu;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired StudentDAO Studentdao;
	
	@Override
	public List<Stu> getAll() {
		// TODO Auto-generated method stub
		return Studentdao.selectByExampleWithPro();
	}

}
