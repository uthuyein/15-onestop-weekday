package com.jdc.mkt.test.jpql;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.Customer;
import com.jdc.mkt.test.JpaFactory;

@SuppressWarnings("unchecked")
public class A_Query_vs_TypeQuery_Test extends JpaFactory{

	@Test
	@Disabled
	void queryTest() {
		var query = em.createQuery("select c from Customer c");
		List<Customer> list = (List<Customer>)query.getResultList();
		System.out.println(list);
	}
	
	@Test
	void typedQueryTest() {
		var query = em.createQuery("select c from Customer c",Customer.class);
		List<Customer> list = query.getResultList();
		System.out.println(list);
	}
}
