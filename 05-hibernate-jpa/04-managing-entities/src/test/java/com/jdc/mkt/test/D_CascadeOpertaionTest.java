package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Person;
import com.jdc.mkt.utils.JpaFactory;

public class D_CascadeOpertaionTest extends JpaFactory{
	
	@Test
	void removeTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var p = em.find(Person.class, 1);
		
		em.remove(p);
		
		em.getTransaction().commit();
	}

	@Test
	@Disabled
	void insertTest() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var p = new Person();
		p.setName("Argos");
		p.setAge(23);
		
		var a = new Address();
		a.setState("Yangon");
		a.setTownship("Innsein");
		a.setStreet("Htantapin");
		
		p.setAddress(a);
		em.persist(p);
		
		
		
		em.getTransaction().commit();
	}
}
