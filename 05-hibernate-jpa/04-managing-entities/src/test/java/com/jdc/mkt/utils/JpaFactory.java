package com.jdc.mkt.utils;

import org.junit.jupiter.api.BeforeAll;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	protected static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("managing-entities");
		
	}
	
	
}
