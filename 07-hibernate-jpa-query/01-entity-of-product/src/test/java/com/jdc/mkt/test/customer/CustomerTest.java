package com.jdc.mkt.test.customer;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.Address;
import com.jdc.mkt.entity.customers.Contact;
import com.jdc.mkt.entity.customers.Customer;
import com.jdc.mkt.entity.customers.Customer.MemberType;
import com.jdc.mkt.test.JpaFactory;

public class CustomerTest extends JpaFactory{

	@Test
	void addCustomer() {
		var cu = new Customer();
		cu.setUsername("andrew");
		cu.setLoginId("user");
		cu.setPassword("123");
		cu.setMemberType(MemberType.Silver);
		
		var cont = new Contact();
		cont.setPrimaryPhone("09-234234");
		cont.setEmail("andrew@gmail.com");
		
		
		var add = new Address();
		add.setState("Yangon");
		add.setTownship("Innsein");
		add.setStreet("Htantapin");
		
		cu.setContact(cont);
		cu.setAddress(add);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cu);
		em.getTransaction().commit();
		
	}
}
