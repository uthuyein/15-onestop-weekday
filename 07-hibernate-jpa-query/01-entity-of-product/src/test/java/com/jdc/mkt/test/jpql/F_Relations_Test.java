package com.jdc.mkt.test.jpql;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.sales.dto.SelectCNameAndAStreet;
import com.jdc.mkt.test.JpaFactory;

@SuppressWarnings("unused")
public class F_Relations_Test extends JpaFactory{

	@Test
	@Order(1)
	void singleFieldWithoutJoinTest() {
		var jpql = """
				select s.customer.username from Sale s 
				where s.saleDate between :from and :to
				""";
		var query = em.createQuery(jpql,String.class);
		query.setParameter("from", LocalDate.of(2025, 05, 22));
		query.setParameter("to",  LocalDate.of(2025, 05, 24));
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Order(2)
	void singleFieldWithJoinTest() {
		
		var jpql = """
				select new com.jdc.mkt.entity.sales.dto.SelectCNameAndAStreet(
				cu.username,a.street )from Sale s
				join s.customer cu  
				join cu.address a
				where s.saleDate = :date and a.township = :township
				""";
		var query = em.createQuery(jpql,SelectCNameAndAStreet.class);
		query.setParameter("date", LocalDate.of(2025, 05, 22));
		query.setParameter("township", "InnSein");
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Order(3)
	void collectionWithJoinTest() {	
		var jpqlFromSale="""
				select s.saleDate from Sale s
				where s.customer.username = :name
				""";
		var jpqlFromCu = """
				select s.saleDate from Customer c 
				join c.sales s
				where c.username = :name
				""";
		var query = em.createQuery(jpqlFromSale,LocalDate.class);
		query.setParameter("name", "John");
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Order(4)
	void selectProductByCu() {
		var jpql ="""
				select sd.salePrice.product from Customer c 
				join c.sales s
				join s.saleDetails sd
				where c.username = :name
				""";
		var query = em.createQuery(jpql,Product.class);
		query.setParameter("name", "John");
		var list = query.getResultList();
		System.out.println(list);
		
	}
}
