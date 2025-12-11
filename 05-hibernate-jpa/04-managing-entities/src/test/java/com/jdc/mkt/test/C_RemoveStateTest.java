package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.utils.JpaFactory;

public class C_RemoveStateTest extends JpaFactory{

	@Test
	void removeTest() {
		var em = emf.createEntityManager();	
		em.getTransaction().begin();
		
		//To be managed state
		var add = em.find(Address.class, 1);
		assertTrue(em.contains(add));
		
		var list = add.getPersons();
		list.remove(0);
		
		//To be removed state
		//em.remove(p);
		//assertFalse(em.contains(add));
		
		em.getTransaction().commit();
		
	}
}
