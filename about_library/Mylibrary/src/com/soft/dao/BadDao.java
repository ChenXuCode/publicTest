package com.soft.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.soft.bean.Bad;
import com.soft.bean.Sjgl;
import com.soft.util.JDBCUtility;

public class BadDao {
	private JDBCUtility jdbc = null;

	public BadDao() {
		jdbc = new JDBCUtility();
	}

	public ArrayList<Bad> getAll() throws ClassNotFoundException, IOException,
			SQLException {
		ArrayList<Bad> list = new ArrayList<>();
		String sql = "select * from tb_bad";
		ResultSet rs = jdbc.executeQuery(sql);
		while (rs.next()) {
			Bad b = new Bad();
			b.setId(rs.getInt("id"));
			b.setUsername(rs.getString("username"));
			b.setType(rs.getString("type"));
			b.setStudentid(rs.getString("studentid"));
			b.setPhone(rs.getString("phone"));
			list.add(b);
		}
		return list;
	}

	// 根据搜索条件和搜索关键字查询符合条件的记录列表
	public ArrayList<Bad> getbycondition(String type, String value)
			throws ClassNotFoundException, SQLException, IOException {
		ArrayList<Bad> list = new ArrayList<Bad>();
		String sql = "select * from tb_bad where " + type + " like '%" + value
				+ "%'";
		ResultSet rs = jdbc.executeQuery(sql);
		while (rs.next()) {
			Bad b = new Bad();
			b.setId(rs.getInt("id"));
			b.setUsername(rs.getString("username"));
			b.setType(rs.getString("type"));
			b.setStudentid(rs.getString("studentid"));
			b.setPhone(rs.getString("phone"));
			list.add(b);
		}
		return list;
	}

	// 添加一条记录
	public boolean inserOne(Bad b) throws ClassNotFoundException, SQLException,
			IOException {
		boolean flag = false;
		if (b != null) {
			String sql = "insert into tb_bad values(null,'" + b.getUsername()
					+ "','" + b.getType() + "','" + b.getStudentid() + "','"
					+ b.getPhone() + "')";
			System.out.println(sql);
			flag = jdbc.executeUpdate(sql);
		}
		return flag;
	}

	// 修改一条记录
	public boolean updateOne(Bad b) throws ClassNotFoundException,
			SQLException, IOException {
		if (b == null)
			return false;
		String sql = "update tb_bad set username=?,type=?,studentid=?,phone=? where id=?";
		java.sql.PreparedStatement pst = jdbc.getConnection().prepareStatement(
				sql);
		pst.setString(1, b.getUsername());
		pst.setString(2, b.getType());
		pst.setString(3, b.getStudentid());
		pst.setString(4, b.getPhone());
		pst.setInt(5, b.getId());
		System.out.println(b.getId());
		int i = pst.executeUpdate();
		return i > 0 ? true : false;
	}
	// 删除一条记录
	public boolean deleteOne(int id) throws ClassNotFoundException,SQLException, IOException {
		boolean flag = false;
		if (id > 0) {
			String sql = "delete from tb_bad where id=" + id;
			System.out.println(sql);
			flag = jdbc.executeUpdate(sql);
		}
		return flag;
	}
}
