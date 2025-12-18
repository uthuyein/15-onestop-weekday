package com.jdc.mkt.test.jpql;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.Customer;
import com.jdc.mkt.test.JpaFactory;

public class E_Predicate_Test extends JpaFactory{

	@Test
	@Order(1)
	void useBetweenTest() {
		var query = em.createQuery("""
				select c from Customer c 
				where c.password between :from and :to
				""",Customer.class);
		query.setParameter("from", "127");
		query.setParameter("to", "213");
		var list = query.getResultList();
		show(list);
	}
	
	@Test
	@Order(2)
	void useInTest() {
		var query = em.createQuery("""
				select c from Customer c 
				where c.password in (:one,:two)
				""",Customer.class);
		query.setParameter("one", "127");
		query.setParameter("two", "213");
		var list = query.getResultList();
		show(list);
	}
	
	@Test
	@Order(3)
	void useNestedTest() {
		var query = em.createQuery("""
				select c from Customer c 
				where c.password <> (select max(c.password) from Customer c)
				""",Customer.class);
		var list = query.getResultList();
		show(list);
	}
}
