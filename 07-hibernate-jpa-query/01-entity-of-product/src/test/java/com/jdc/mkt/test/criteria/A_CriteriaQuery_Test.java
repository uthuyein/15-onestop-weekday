package com.jdc.mkt.test.criteria;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.test.JpaFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class A_CriteriaQuery_Test  extends JpaFactory{

	
	@Test
	@Disabled
	@Order(1)
	//select p from Product p
	void criteriaQeuryTest() {
		
		//create criteria builder obj
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		//create criteria query
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		
		// from Product p
		Root<Product> root = cq.from(Product.class);
		
		//select p from Product p
		 cq.select(root);
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		System.out.println(list);
	}
}
