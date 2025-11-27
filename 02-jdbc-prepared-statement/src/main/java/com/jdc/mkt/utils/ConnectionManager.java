package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/saleDb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	public static void createTable() {
		try(var con = getConnection(); 
			var stmt = con.createStatement()){
			
			stmt.addBatch("""
					create table if not exists category_tbl(
						id int primary key auto_increment,
						name varchar(45) not null unique
					);
					""");
			stmt.addBatch("""
					create table if not exists product_tbl(
						id int primary key auto_increment,
						name varchar(45) not null,
						price int ,
						category_id int,
						foreign key (category_id) references category_tbl(id)
					);
					""");
			stmt.executeBatch();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
