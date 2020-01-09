package com.soft.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.soft.bean.Tsyl;
import com.soft.util.JDBCUtility;

public class TsylDao {
	private JDBCUtility jdbc=null;
	public TsylDao()
	{
		jdbc=new JDBCUtility();
	}
	public ArrayList<Tsyl> getAll() throws ClassNotFoundException,IOException, SQLException
	{
		ArrayList<Tsyl> list=new ArrayList<>();
		String sql="select * from tb_books";
		ResultSet rs=jdbc.executeQuery(sql);
		while (rs.next()) {
			Tsyl t=new Tsyl();
			t.setId(rs.getInt("id"));
			t.setBook(rs.getString("book"));
			t.setAuthor(rs.getString("author"));			
			t.setPrice(rs.getInt("price"));
			t.setPress(rs.getString("press"));
			t.setType(rs.getString("type"));
			t.setNumber(rs.getInt("number"));
			t.setHave(rs.getInt("have"));
			t.setUnhave(rs.getInt("unhave"));
			t.setLocation(rs.getString("location"));
			list.add(t);
		}
		return list;
	}
	public ArrayList<Tsyl> getjsj() throws ClassNotFoundException,IOException, SQLException
	{
		ArrayList<Tsyl> list=new ArrayList<>();
		String sql="select * from tb_books where type=1";
		ResultSet rs=jdbc.executeQuery(sql);
		while (rs.next()) {
			Tsyl t=new Tsyl();
			t.setId(rs.getInt("id"));
			t.setBook(rs.getString("book"));
			t.setAuthor(rs.getString("author"));			
			t.setPrice(rs.getInt("price"));
			t.setPress(rs.getString("press"));
			t.setType(rs.getString("type"));
			t.setNumber(rs.getInt("number"));
			t.setHave(rs.getInt("have"));
			t.setUnhave(rs.getInt("unhave"));
			t.setLocation(rs.getString("location"));
			list.add(t);
		}
		return list;
	}
	public ArrayList<Tsyl> getkx() throws ClassNotFoundException,IOException, SQLException
	{
		ArrayList<Tsyl> list=new ArrayList<>();
		String sql="select * from tb_books where type=2";
		ResultSet rs=jdbc.executeQuery(sql);
		while (rs.next()) {
			Tsyl t=new Tsyl();
			t.setId(rs.getInt("id"));
			t.setBook(rs.getString("book"));
			t.setAuthor(rs.getString("author"));			
			t.setPrice(rs.getInt("price"));
			t.setPress(rs.getString("press"));
			t.setType(rs.getString("type"));
			t.setNumber(rs.getInt("number"));
			t.setHave(rs.getInt("have"));
			t.setUnhave(rs.getInt("unhave"));
			t.setLocation(rs.getString("location"));
			list.add(t);
		}
		return list;
	}
	public ArrayList<Tsyl> getxs() throws ClassNotFoundException,IOException, SQLException
	{
		ArrayList<Tsyl> list=new ArrayList<>();
		String sql="select * from tb_books where type=3";
		ResultSet rs=jdbc.executeQuery(sql);
		while (rs.next()) {
			Tsyl t=new Tsyl();
			t.setId(rs.getInt("id"));
			t.setBook(rs.getString("book"));
			t.setAuthor(rs.getString("author"));			
			t.setPrice(rs.getInt("price"));
			t.setPress(rs.getString("press"));
			t.setType(rs.getString("type"));
			t.setNumber(rs.getInt("number"));
			t.setHave(rs.getInt("have"));
			t.setUnhave(rs.getInt("unhave"));
			t.setLocation(rs.getString("location"));
			list.add(t);
		}
		return list;
	}
	public ArrayList<Tsyl> getert() throws ClassNotFoundException,IOException, SQLException
	{
		ArrayList<Tsyl> list=new ArrayList<>();
		String sql="select * from tb_books where type=4";
		ResultSet rs=jdbc.executeQuery(sql);
		while (rs.next()) {
			Tsyl t=new Tsyl();
			t.setId(rs.getInt("id"));
			t.setBook(rs.getString("book"));
			t.setAuthor(rs.getString("author"));			
			t.setPrice(rs.getInt("price"));
			t.setPress(rs.getString("press"));
			t.setType(rs.getString("type"));
			t.setNumber(rs.getInt("number"));
			t.setHave(rs.getInt("have"));
			t.setUnhave(rs.getInt("unhave"));
			t.setLocation(rs.getString("location"));
			list.add(t);
		}
		return list;
	}
	public ArrayList<Tsyl> getzz() throws ClassNotFoundException,IOException, SQLException
	{
		ArrayList<Tsyl> list=new ArrayList<>();
		String sql="select * from tb_books where type=5";
		ResultSet rs=jdbc.executeQuery(sql);
		while (rs.next()) {
			Tsyl t=new Tsyl();
			t.setId(rs.getInt("id"));
			t.setBook(rs.getString("book"));
			t.setAuthor(rs.getString("author"));			
			t.setPrice(rs.getInt("price"));
			t.setPress(rs.getString("press"));
			t.setType(rs.getString("type"));
			t.setNumber(rs.getInt("number"));
			t.setHave(rs.getInt("have"));
			t.setUnhave(rs.getInt("unhave"));
			t.setLocation(rs.getString("location"));
			list.add(t);
		}
		return list;
	}
	public ArrayList<Tsyl> getbyName(String book) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Tsyl> list=new ArrayList<>();
		String sql="select * from tb_books where book like '%"+book+"%'";
		System.out.println(sql);
		ResultSet rs=jdbc.executeQuery(sql);
		while (rs.next()) {
			Tsyl t=new Tsyl();
			t.setId(rs.getInt("id"));
			t.setBook(rs.getString("book"));
			t.setAuthor(rs.getString("author"));			
			t.setPrice(rs.getInt("price"));
			t.setPress(rs.getString("press"));
			t.setType(rs.getString("type"));
			t.setNumber(rs.getInt("number"));
			t.setHave(rs.getInt("have"));
			t.setUnhave(rs.getInt("unhave"));
			t.setLocation(rs.getString("location"));
			list.add(t);
		}
		return list;	
	}
	//添加一条记录
	public boolean inserOne(Tsyl t) throws ClassNotFoundException, SQLException, IOException
	{
		boolean flag=false;
		if (t!=null) {
			String sql="insert into tb_books values(null,'"+t.getBook()+"','"+t.getAuthor()
					+"','"+t.getPrice()+"','"+t.getPress()
					+"','"+t.getType()+"','"+t.getNumber()+"','"
					+t.getHave()+"','"+t.getUnhave()+
					"','"+t.getLocation()+"')";
			System.out.println(sql);
			flag=jdbc.executeUpdate(sql);
		}
		return flag;
	}
	//删除一条记录
	public boolean deleteOne(int id) throws ClassNotFoundException, SQLException, IOException
	{
		boolean flag=false;
		if (id>0) {
			String sql="delete from tb_books where id="+id;
			System.out.println(sql);
			flag=jdbc.executeUpdate(sql);
		}
		return flag;
	}
	//修改一条记录
	public boolean updateOneWare(Tsyl t) throws ClassNotFoundException, SQLException, IOException
	{
		if (t==null)
			return false; 
		String sql="update tb_books set book=?,author=?,price=?,"
			+"press=?,type=?,number=?,have=?,unhave=?,location=? where id=?";
		java.sql.PreparedStatement pst=jdbc.getConnection().prepareStatement(sql);
		pst.setString(1,t.getBook() );
		pst.setString(2, t.getAuthor());
		pst.setInt(3, t.getPrice());
		pst.setString(4, t.getPress());
		pst.setString(5,t.getType());
		pst.setInt(6, t.getNumber());
		pst.setInt(7, t.getHave());
		pst.setInt(8, t.getUnhave());
		pst.setString(9, t.getLocation());
		pst.setInt(10, t.getId());
		System.out.println(t.getId());
		int i=pst.executeUpdate();
		return i>0?true:false;
	}
	
}
