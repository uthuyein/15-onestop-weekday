package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/testDb";
	private static final String HURL= "jdbc:h2:file:./testDb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static int truncate() {
		try (var con = getConnection(); var stmt = con.createStatement()) {

			return stmt.executeUpdate("truncate table user_tbl");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int[] executBatch() {
		try (var con = getConnection(); var stmt = con.createStatement()) {

			stmt.addBatch("insert into user_tbl(username,loginId,password)values('aaa','aaa','111')");
			stmt.addBatch("insert into user_tbl(username,loginId,password)values('bbb','bbb','222')");
			stmt.addBatch("insert into user_tbl(username,loginId,password)values('ccc','ccc','333')");

			return stmt.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public static int createTable() {
		try (var con = getConnection(); var stmt = con.createStatement()) {

			stmt.execute("""
					create table if not exists user_tbl(
					 id int primary key auto_increment,
					 username varchar(45) not null ,
					 loginId varchar(45) not null unique,
					 password varchar(45) not null
					);
					""");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
