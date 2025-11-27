package com.jdc.mkt.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jdc.mkt.entity.User;

public class UserService {

	private static final String URL = "jdbc:mysql://localhost:3306/testDb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	public Connection getConnection() throws SQLException {
		// return DriverManager.getConnection(URL, USER, PASSWORD);
		// return DriverManager.getConnection(URL+"?user=root&password=admin");
		return DriverManager.getConnection(URL, getProp());
	}

	public Properties getProp() {
		var prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		return prop;
	}

	public int insert(User user) throws SQLException {
		Statement stmt = getConnection().createStatement();
		var row = stmt.executeUpdate("""
				insert into user_tbl(username,loginId,password)
				values('%s','%s','%s')
				""".formatted(user.getUsername(), user.getLoginId(), user.getPassword()));
		stmt.close();
		getConnection().close();
		return row;
	}

	public int update(User user) {
		try (var con = getConnection(); var stmt = con.createStatement()) {

			int row = stmt.executeUpdate("""
					update user_tbl set username = '%s',password = '%s'
					where id = '%s'
					""".formatted(user.getUsername(), user.getPassword(), user.getId()));
			return row;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		try (var con = getConnection(); var stmt = con.createStatement()) {

			int row = stmt.executeUpdate("""
					delete from user_tbl where id = %d
					""".formatted(id));
			return row;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<User> select() {
		var list = new ArrayList<User>();

		try (var con = getConnection(); var stmt = con.createStatement()) {
			var rs = stmt.executeQuery("select * from user_tbl");

			while (rs.next()) {
				var user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginId(rs.getString("loginId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int truncate() {
		try (var con = getConnection(); var stmt = con.createStatement()) {

			return stmt.executeUpdate("truncate table user_tbl");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int[] executBatch() {
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

	public int createTable() {
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
