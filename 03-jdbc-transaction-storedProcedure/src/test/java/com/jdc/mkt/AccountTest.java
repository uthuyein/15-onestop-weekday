package com.jdc.mkt;

import static com.jdc.mkt.utitls.AccountCreator.createOrTruncate;
import static com.jdc.mkt.utitls.AccountCreator.initData;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.services.AccountService;

public class AccountTest {

	private AccountService service = new AccountService();

	@BeforeAll
	static void init() {
		createOrTruncate("truncate");
		initData("William", 50000);
		initData("John", 50000);
	}

	@Test
	void test() throws SQLException {
		service.transfer("William", "John", 10000);

	}
}
