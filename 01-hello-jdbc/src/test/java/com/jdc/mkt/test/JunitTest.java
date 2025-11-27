package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class JunitTest {

	@BeforeAll
	static void beforeall() {
		System.out.println("Using Before All");
	}
	@AfterAll
	static void afterall() {
		System.out.println("Using After All");
	}
	@BeforeEach
	void beforeach() {
		System.out.println("Using Before Each");
	}
	@AfterEach
	void aftereach() {
		System.out.println("Using After Each");
	}
	@Test
	@Order(2)
	void testOne() {
		System.out.println("Using Test One");
		var actual = "bb";
		assertNotEquals("aa",actual);
		assertTrue(true);
	}
	@Test
	@Order(1)
	void testTwo() {
		System.out.println("Using Test Two");
	}
}
