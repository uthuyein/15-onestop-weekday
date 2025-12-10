package com.jdc.mkt.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.Course;
import com.jdc.mkt.PrintLogger;
import com.jdc.mkt.Student;
import com.jdc.mkt.converter.Data;
import com.jdc.mkt.utils.DatabaseType;
import com.jdc.mkt.utils.anno.Connector;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Connector(
		database = DatabaseType.MYSQL,
		password = "admin",
		user = "root",
		port = "3306")
public class JpaFactory {

	protected static EntityManagerFactory emf;
	
	@BeforeAll
	protected static void init() {
		emf = Persistence.createEntityManagerFactory("inheritance-mapping");
	}
	
	@AfterEach
	void showlog() {
		var logger = PrintLogger.getInstance(JpaFactory.class);
		logger.printTableByStringQuery("select * from account");
	}
	
	@Test
	void test() {
		var em = emf.createEntityManager();
		
		var stu = new Student();
		stu.setLoginId("andrew");
		stu.setUsername("stu");
		stu.setPassword("stu");
		
		var dt = new Data();
		dt.setKey(22);
		dt.setValue("testing");
		stu.setData(dt);
	
		var course = new Course();
		course.setName("Java Basic");
		stu.setCourse(course);
		
		em.getTransaction().begin();
		em.persist(course);
		em.persist(stu);
		em.getTransaction().commit();
		
	}
}
