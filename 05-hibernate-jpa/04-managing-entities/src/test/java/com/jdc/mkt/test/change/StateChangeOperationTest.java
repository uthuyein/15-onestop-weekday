package com.jdc.mkt.test.change;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Person;
import com.jdc.mkt.utils.JpaFactory;

import jakarta.persistence.PersistenceException;

public class StateChangeOperationTest extends JpaFactory{
	
	@Test
	void removeTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//To be manage
		var add = em.find(Address.class, 1);
		assertTrue(em.contains(add));
		
		//To be remove
		em.remove(add);
		assertFalse(em.contains(add));
		
		//To be manage
		em.persist(add);
		assertTrue(em.contains(add));
		
		//To be detached
		em.detach(add);
		assertFalse(em.contains(add));
		
		assertThrows(IllegalArgumentException.class, () -> em.remove(add));
		
		em.getTransaction().commit();
	}
	
	@Test
	@Disabled
	void mergeTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//To be transient
		var add = new Address("Yangon", "Lathar", "41st");
		
		//To be manage
		var newAdd = em.merge(add);
		assertTrue(em.contains(newAdd));
		
		//To be detached
		em.detach(newAdd);
		assertFalse(em.contains(newAdd));
		
		//To be manage
		var nAdd = em.merge(newAdd);
		assertTrue(em.contains(nAdd));
		
		//To be remove
		em.remove(nAdd);
		assertFalse(em.contains(nAdd));
		
		assertThrows(IllegalArgumentException.class, () -> em.merge(nAdd));
		
		
		em.getTransaction().commit();
	}

	@Test
	@Disabled
	void persistTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//To be transient 
		var add = new Address("Mandalay","Patheingyi","19st");	
		add.addPerson(new Person("William",40),new Person("Snowei",34));
		
		//To be managed
		em.persist(add);
		assertTrue(em.contains(add));
		
		//To be remove
		em.remove(add);
		assertFalse(em.contains(add));
		
		
		//To be manage
		em.persist(add);
		assertTrue(em.contains(add));
		
		//To be detached
		em.detach(add);
		assertFalse(em.contains(add));
		
	
		assertThrows(PersistenceException.class, () -> em.persist(add));
		
		em.getTransaction().commit();
	}
}
