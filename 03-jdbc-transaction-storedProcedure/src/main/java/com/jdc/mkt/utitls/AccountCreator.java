package com.jdc.mkt.utitls;

import static com.jdc.mkt.utitls.ConnectionManager.getConnection;

public class AccountCreator {

	static String create = """
			create table if not exists account_tbl(
				id int primary key auto_increment,
				name varchar(45) not null,
				balance int
			);
			""";
	static String truncate = "truncate table account_tbl";
	
	public static void createOrTruncate(String query) {	
		try (var con = getConnection(); 
				var stmt = con.createStatement()) {
			stmt.executeUpdate(query.equals("create")? create : truncate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initData(String name, int balance) {
		String sql = "insert into account_tbl(name,balance)values(?,?)";

		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setInt(2, balance);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
