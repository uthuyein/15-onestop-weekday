package com.jdc.mkt.test.jpql;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.Address;
import com.jdc.mkt.entity.customers.dto.SelectNameEmailStreet;
import com.jdc.mkt.test.JpaFactory;

public class D_Projection_Test extends JpaFactory{

	@Test	
	@Order(1)
	void selectWithNewOperator() {
		var query = em.createQuery( """
				select new com.jdc.mkt.entity.customers.Address(
				a.state,a.township,a.street) 
				from Address a
				""",Address.class);
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Order(2)
	void selectUserNameEmailStreetWithNewOperator() {
		var query = em.createQuery("""
				select new com.jdc.mkt.entity.customers.dto.SelectNameEmailStreet(
				cu.username,cu.contact.email,cu.address.street)  
				from Customer cu
				""",SelectNameEmailStreet.class);
				
		var list = query.getResultList();
		System.out.println(list);
	}
}
