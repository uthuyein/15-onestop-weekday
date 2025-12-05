package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.Course;
import com.jdc.mkt.Student;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaFactory {

	protected static EntityManagerFactory emf;
	
	@BeforeAll
	protected static void init() {
		emf = Persistence.createEntityManagerFactory("inheritance-mapping");
	}
	
	@Test
	void test() {
		var em = emf.createEntityManager();
		
		var stu = new Student();
		stu.setLoginId("andrew");
		stu.setUsername("stu");
		stu.setPassword("stu");
		
		var course = new Course();
		course.setName("Java Basic");
		stu.setCourse(course);
		
		em.getTransaction().begin();
		em.persist(course);
		em.persist(stu);
		em.getTransaction().commit();
		
	}
}
