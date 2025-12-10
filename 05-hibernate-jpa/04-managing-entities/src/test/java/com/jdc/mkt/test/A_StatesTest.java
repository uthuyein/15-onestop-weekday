package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Person;
import com.jdc.mkt.utils.JpaFactory;

public class A_StatesTest extends JpaFactory{
	
	

	@Test
	void selectTest() {
		var em = emf.createEntityManager();
		
		//To Be Managed State
		var add = em.find(Address.class, 1);
		assertNotNull(add);
		assertTrue(em.contains(add));
		//assertEquals("Mandalay", add.getState());
		//var size = add.getPersons().size();
		
	}
	
	@Test
	@Disabled
	void persistTest() {
		var em = emf.createEntityManager();
		
		//To Be Transient State
		var person = new Person();
		person.setName("Kelvin");
		person.setAge(30);
		
		var address = new Address();
		address.setState("Mandalay");
		address.setTownship("Mahar AungMyay");
		address.setStreet("42st ,bet 84stX84st");
		
		//person.setAddress(address);
		
		em.getTransaction().begin();
		
		//To Be Managed State
		em.persist(person);
		em.persist(address);
		
		em.getTransaction().commit();
		
	}
}
