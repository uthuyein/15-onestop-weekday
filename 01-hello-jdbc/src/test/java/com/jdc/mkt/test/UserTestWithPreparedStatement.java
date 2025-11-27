package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.User;
import com.jdc.mkt.services.UserServiceWithPreparedStatement;
import static com.jdc.mkt.utils.ConnectionManager.*;

public class UserTestWithPreparedStatement {

	private static UserServiceWithPreparedStatement service;
	
	@BeforeAll
	static void init() {
		service = new UserServiceWithPreparedStatement();
		createTable();
		truncate();
		executBatch();
	}
	
	@Test
	void insertTest() {
		var user = new User();
		user.setLoginId("Kelvin");
		user.setUsername("Kelvin");
		user.setPassword("admin");
		var row = service.insert(user);
		assertEquals(1, row);
	}
}
