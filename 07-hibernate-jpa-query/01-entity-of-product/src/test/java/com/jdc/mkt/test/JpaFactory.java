package com.jdc.mkt.test;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.jdc.mkt.PrintLogger;
import com.jdc.mkt.entity.customers.Customer;
import com.jdc.mkt.utils.anno.Connector;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Connector(name = "prodDb", user = "prodUser", password = "prodPass", port = "3306")
public class JpaFactory {

	protected static EntityManagerFactory emf;
	protected static PrintLogger logger;
	protected EntityManager em;
	
	@BeforeAll
	protected static void init() {
		emf = Persistence.createEntityManagerFactory("entity-of-product");
		logger = PrintLogger.getInstance(JpaFactory.class);
	}

	@AfterAll
	protected static void closeEmf() {
		if (null != emf && emf.isOpen())
			emf.close();
	}

	@BeforeEach
	protected void createEm() {	
		em = emf.createEntityManager();
	}

	@AfterEach
	protected void closeEm() {
		if (null != em && em.isOpen())
			em.close();
	}
	
	protected void show(List<Customer> list) {
		for(Customer c :list) {
			System.out.println("Name :"+c.getUsername());
		}
	}

}
