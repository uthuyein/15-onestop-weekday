package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Person;
import com.jdc.mkt.utils.JpaFactory;

public class A_ManageStatesTest extends JpaFactory{
	
	
	@Test 
	void updateTest() {
		var em = emf.createEntityManager();
		
		//To Be Managed State
		var person = em.find(Person.class, 1);
		assertTrue(em.contains(person));
		
		
		//To Be Detached Stated
		em.detach(person);
		assertFalse(em.contains(person));
		
		
		//To Be Managed Stated
		var pnew = em.merge(person);
		assertFalse(em.contains(person));
		assertTrue(em.contains(pnew));
		
		em.getTransaction().begin();
		
		pnew.setName("John wick");
		
	
		em.getTransaction().commit();
		em.close();
	}

	@Test
	@Disabled
	void selectTest() {
		var em = emf.createEntityManager();
		
		//To Be Managed State
		var add = em.getReference(Address.class, 1);
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
		
		person.setAddress(address);
		
		em.getTransaction().begin();
		
		//To Be Managed State
		em.persist(person);
		em.persist(address);
		
		em.getTransaction().commit();
		
	}
}
