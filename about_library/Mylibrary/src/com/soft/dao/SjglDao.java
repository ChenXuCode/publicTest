package com.soft.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.soft.bean.Sjgl;
import com.soft.bean.Tsyl;
import com.soft.util.JDBCUtility;

public class SjglDao {
	private JDBCUtility jdbc = null;

	public SjglDao() {
		jdbc = new JDBCUtility();
	}

	public ArrayList<Sjgl> getAll() throws ClassNotFoundException, IOException,
			SQLException {
		ArrayList<Sjgl> list = new ArrayList<>();
		String sql = "select * from tb_user";
		ResultSet rs = jdbc.executeQuery(sql);
		while (rs.next()) {
			Sjgl s = new Sjgl();
			s.setId(rs.getInt("id"));
			s.setUsername(rs.getString("username"));
			s.setBookname(rs.getString("bookname"));
			s.setStudentid(rs.getString("studentid"));
			s.setPhone(rs.getString("phone"));
			s.setTime(rs.getString("time"));
			s.setNumber(rs.getString("number"));
			list.add(s);
		}
		return list;
	}

	// 根据搜索条件和搜索关键字查询符合条件的记录列表
	public ArrayList<Sjgl> getbycondition(String type, String value)
			throws ClassNotFoundException, SQLException, IOException {
		ArrayList<Sjgl> list = new ArrayList<Sjgl>();
		String sql = "select * from tb_user where " + type + " like '%" + value
				+ "%'";
		ResultSet rs = jdbc.executeQuery(sql);
		while (rs.next()) {
			Sjgl s = new Sjgl();
			s.setId(rs.getInt("id"));
			s.setUsername(rs.getString("username"));
			s.setBookname(rs.getString("bookname"));
			s.setStudentid(rs.getString("studentid"));
			s.setPhone(rs.getString("phone"));
			s.setTime(rs.getString("time"));
			s.setNumber(rs.getString("number"));
			list.add(s);
		}
		return list;
	}

	// 添加一条记录
	public boolean inserOne(Sjgl s) throws ClassNotFoundException,
			SQLException, IOException {
		boolean flag = false;
		if (s != null) {
			String sql = "insert into tb_user values(null,'" + s.getUsername()
					+ "','" + s.getBookname() + "','" + s.getStudentid()
					+ "','" + s.getPhone() + "','" + s.getTime() + "','"
					+ s.getNumber() + "')";
			System.out.println(sql);
			flag = jdbc.executeUpdate(sql);
		}
		return flag;
	}

	// 修改一条记录
	public boolean updateOne(Sjgl s) throws ClassNotFoundException,SQLException, IOException {
		if (s == null)
			return false;
		String sql = "update tb_user set username=?,bookname=?,studentid=?,"
				+ "phone=?,time=?,number=? where id=?";
		java.sql.PreparedStatement pst = jdbc.getConnection().prepareStatement(sql);
		pst.setString(1, s.getUsername());
		pst.setString(2, s.getBookname());
		pst.setString(3, s.getStudentid());
		pst.setString(4, s.getPhone());
		pst.setString(5, s.getTime());
		pst.setString(6, s.getNumber());
		pst.setInt(7, s.getId());
		System.out.println(s.getId());
		int i = pst.executeUpdate();
		return i > 0 ? true : false;
	}
	//删除一条记录
	public boolean deleteOne(int id) throws ClassNotFoundException, SQLException, IOException
	{
		boolean flag=false;
		if (id>0) {
			String sql="delete from tb_user where id="+id;
			System.out.println(sql);
			flag=jdbc.executeUpdate(sql);
		}
		return flag;
	}
	
}
