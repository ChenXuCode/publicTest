package com.soft.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtility {
	private String driver;
	private String url;
	private String name;
	private String pass;
	private Connection con;
	private Statement st;

	public void getdatabase() throws IOException {
		Properties p = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(
				"lib/database.properties"));
		p.load(in);
		driver=p.getProperty("driver");
		url=p.getProperty("url");
		name=p.getProperty("name");
		pass=p.getProperty("pass");
		in.close();
	}

	public Connection getConnection() throws SQLException,
			ClassNotFoundException, IOException {
		if (con == null) {
			getdatabase();
			Class.forName(driver);
			con = DriverManager.getConnection(url, name, pass);
		}
		return con;
	}

	public Statement getStatement() throws SQLException, ClassNotFoundException, IOException {
		if (con == null)
			getConnection();
		if (st == null)
			st = con.createStatement();
		return st;
	}

	public boolean executeUpdate(String sql) throws SQLException,
			ClassNotFoundException, IOException {
		if (st == null)
			getStatement();
		int h = st.executeUpdate(sql);
		return (h > 0 ? true : false);
	}

	public ResultSet executeQuery(String sql) throws SQLException,
			ClassNotFoundException, IOException {
		if (st == null)
			getStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public void close() throws SQLException {
		if (st != null)
			st.close();
		if (con != null)
			con.close();
	}

}
