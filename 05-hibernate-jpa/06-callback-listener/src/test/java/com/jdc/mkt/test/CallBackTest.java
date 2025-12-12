package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Course;
import com.jdc.mkt.entity.Teacher;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CallBackTest {
	
	EntityManagerFactory emf;
	
	@Test
	void test() {
		emf = Persistence.createEntityManagerFactory("callback-listener");
		var em = emf.createEntityManager();
		var course = new Course();
		course.setName("Core Java");
		course .setDescription("We will learning about java with apis ");
		var teacher = new Teacher();
		teacher.setName("Andrew");
		teacher.setCourse(course);
		
		em.getTransaction().begin();
		em.persist(teacher);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
