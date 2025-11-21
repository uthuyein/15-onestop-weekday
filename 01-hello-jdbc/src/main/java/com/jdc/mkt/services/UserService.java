package com.jdc.mkt.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jdc.mkt.entity.User;

public class UserService {

	private static final String URL = "jdbc:mysql://localhost:3306/testDb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public int insert(User user) throws SQLException {
		Statement stmt = getConnection().createStatement();
		return stmt.executeUpdate("""
				insert into user_tbl(username,loginId,password) 
				values('%s','%s','%s')
				""".formatted(
						user.getUsername(),
						user.getLoginId(),
						user.getPassword()));
	}
	
	public int update() {
		return 0;
	}
	
	public int delete() {
		return 0;
	}
	
	public List<User> select(){
		return null;
	}
}


