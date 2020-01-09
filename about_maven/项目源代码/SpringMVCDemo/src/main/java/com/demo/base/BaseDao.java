package com.demo.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

	 @Autowired
	 private JdbcTemplate JdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return JdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}
	 
}
