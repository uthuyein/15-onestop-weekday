package com.jdc.mkt.test.jpql;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.Customer;
import com.jdc.mkt.test.JpaFactory;

public class B_Static_Vs_Dynamic_Test extends JpaFactory{

	@Test
	@Disabled
	void staticQueryTestOne() {
		var query = em.createNamedQuery("Customer.selectCustomerByNameLike", Customer.class);
		query.setParameter(1, "m".concat("%"));
		var list = query.getResultList();
		show(list);
	}
	
	@Test
	void staticQueryTestTwo() {
		var query = em.createNamedQuery("Customer.selectCustomerByEmail", Customer.class);
		query.setParameter(1, "mercy@gmail.com");
		var cu = query.getSingleResult();
		System.out.println("User Name ::: "+cu.getUsername());
	}
		
	@Test
	@Disabled
	void dynamicQueryTest() {
		var query = em.createQuery("Select c from Customer c where c.username like ?1",Customer.class);
		query.setParameter(1, "A".concat("%"));
		show(query.getResultList());
	}
	
	
}
