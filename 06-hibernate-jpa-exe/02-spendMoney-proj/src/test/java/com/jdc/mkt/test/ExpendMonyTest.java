package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.IncomesInfo;
import com.jdc.mkt.entity.IncomesInfo.IncomesType;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ExpendMonyTest {

	private static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("spendMoney-proj");
		
	}
	@Test
	void test() {
		var em = emf.createEntityManager();
		var incomes = new IncomesInfo();
		incomes.setDate(LocalDate.now());
		incomes.setIncomesType(IncomesType.Salary);
		incomes.setDescription("for january");
		
		em.getTransaction().begin();
		em.persist(incomes);
		em.getTransaction().commit();
		
	}
}
