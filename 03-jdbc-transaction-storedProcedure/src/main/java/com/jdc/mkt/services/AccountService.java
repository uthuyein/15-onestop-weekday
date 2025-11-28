package com.jdc.mkt.services;

import static com.jdc.mkt.utitls.ConnectionManager.getConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {

	public int update(String from, String to, int balance) throws SQLException {

		Connection con = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			var initialBalance = getBalance(from);

			var stmt = con.createStatement();

			if (initialBalance < balance) {
				throw new RuntimeException("Not Enough amount to transfer !");
			}
			stmt.addBatch("update account_tbl set balance = (balance - %d)  where name = '%s'".formatted(balance, from));

			var secondBalance = getBalance(to);
			
			if(secondBalance <= 0) {
				throw new RuntimeException("Must have initial balance !");
			}
			stmt.addBatch("update account_tbl set balance = (balance + %d)  where name ='%s'".formatted(balance, to));

			stmt.executeBatch();
			con.commit();

		} catch (Exception e) {
			con.rollback();
		} finally {
			con.close();
		}
		return 0;
	}

	public double getBalance(String name) {
		String sql = "select balance from account_tbl where name = ?";
		try (var con = getConnection(); var stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			var rs = stmt.executeQuery();

			while (rs.next()) {
				return rs.getDouble(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
