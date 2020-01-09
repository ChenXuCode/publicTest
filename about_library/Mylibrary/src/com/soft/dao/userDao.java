package com.soft.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.soft.util.JDBCUtility;
import com.soft.bean.User;


public class userDao {
	private JDBCUtility jdbc=null;
	public userDao()
	{
		jdbc=new JDBCUtility();
	}
	public User getoneUser(String name,String pass) throws ClassNotFoundException, SQLException, IOException
	{
		User u=null;
		
		if (name!=null&&!"".equals(name)&&pass!=null&&!"".equals(pass)) {
			String sql="select * from tb_people where name=? and password=?";
			PreparedStatement pst=jdbc.getConnection().prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			if (rs.next()) {
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
			}
		}	
		return u;
	}
}
