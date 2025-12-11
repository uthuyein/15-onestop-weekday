package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Person;
import com.jdc.mkt.utils.JpaFactory;

public class B_DetachedStateTest extends JpaFactory{

	
	@Test
	void detachedTest() {
		var em = emf.createEntityManager();
		
		//To Be Managed Stated
		var p = em.find(Person.class, 1);
		assertTrue(em.contains(p));
		
		//To Be Detached Stated
		em.detach(p);
		assertFalse(em.contains(p));
		p.setName("John wick");
		
		em.getTransaction().begin();
		//To Be Managed Stated
		var pnew = em.merge(p);
		
		assertTrue(em.contains(pnew));
		
		em.getTransaction().commit();
		
		
	}
	
	@Test
	@Disabled
	void clearTest() {
		var em = emf.createEntityManager();
		
		//To Be Managed Stated
		var p = em.find(Person.class, 1);
		assertTrue(em.contains(p));
		
		//To Be Detached Stated
		em.clear();
		assertFalse(em.contains(p));
		
		//To Be Managed Stated
		var pnew = em.merge(p);
		assertTrue(em.contains(pnew));
		
		
	}
}
