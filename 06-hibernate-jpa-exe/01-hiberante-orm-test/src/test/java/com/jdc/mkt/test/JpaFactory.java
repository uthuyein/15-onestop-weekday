package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	protected static EntityManagerFactory emf;
	
	@BeforeAll
	protected static void init() {
		emf = Persistence.createEntityManagerFactory("driving-school-test");
	}
	
	@Test
	void test() {}
}
