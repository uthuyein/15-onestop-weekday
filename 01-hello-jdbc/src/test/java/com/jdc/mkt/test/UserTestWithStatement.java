package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.entity.User;
import com.jdc.mkt.services.UserServiceWithStatement;
import static com.jdc.mkt.utils.ConnectionManager.*;

@TestMethodOrder(OrderAnnotation.class)
public class UserTestWithStatement {

	private static UserServiceWithStatement service;
	
	@BeforeAll
	static void init() {
		service = new UserServiceWithStatement();
		createTable();
		truncate();
		executBatch();
	}
	
	@Test
	@Order(2)
	void selectTest() {
		var list = service.select();
		assertEquals(4, list.size());
	}
	
	@Test
	@Order(3)
	void updateTest() {
		var user = new User();
		user.setUsername("andrew");
		user.setPassword("123");
		user.setId(1);
		var row = service.update(user);
		assertEquals(1, row);
		
	}
	
	@Test
	@Order(4)
	void deleteTest() {	
		var row = service.delete(2);
		assertEquals(1, row);
	}
	
	@Test
	@Order(1)
	void insertTest() throws SQLException {
		
		var user = new User();
		user.setLoginId("admin");
		user.setUsername("bbb");
		user.setPassword("123");
		
		int row = service.insert(user);
		assertEquals(1, row);
	}
}
