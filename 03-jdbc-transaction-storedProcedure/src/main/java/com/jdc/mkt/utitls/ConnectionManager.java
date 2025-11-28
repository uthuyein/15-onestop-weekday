package com.jdc.mkt.utitls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/balanceDb";
	private static final String USER = "bUser";
	private static final String PASSWORD = "bPassword";
	
	private ConnectionManager() {}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USER,PASSWORD);
		
	}
	
	
}
