package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.User;
import com.jdc.mkt.services.UserService;

public class UserTest {

	private static UserService service;
	
	@BeforeAll
	static void init() {
		service = new UserService();
	}
	
	@Test
	void insertTest() throws SQLException {
		
		var user = new User();
		user.setLoginId("admin");
		user.setUsername("bbb");
		user.setPassword("123");
		
		int row = service.insert(user);
		assertEquals(1, row);
	}
}
