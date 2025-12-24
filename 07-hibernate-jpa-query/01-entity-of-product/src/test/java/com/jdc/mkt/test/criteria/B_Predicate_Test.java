package com.jdc.mkt.test.criteria;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.test.ShowProduct;

public class B_Predicate_Test  extends ShowProduct{

	@Test
	@Order(3)
	//select p from Product p where p.category.name in (Snacks,Fruits)
	void selectPNameByCNameInTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Product.class);
		var root = cq.from(Product.class);
		
		cq.select(root);	
		var predicate = cb.in(root.get("category").get("name"))
						.value(List.of("Snacks","Fruits"));
		cq.where(predicate);
		show(cq);
	}
	
	@Test
	@Order(2)
	//select p from Product p where lower(p.name) like lower(:name)
	void selectPNamelikeTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Product.class);
		var root = cq.from(Product.class);
		
		cq.select(root);		
		cq.where(cb.like(cb.lower( root.get("name")), "Y".toLowerCase().concat("%")));
		show(cq);
	}
	
	@Test
	@Order(1)
	//select p from Product p where p.productSize.name = :size
	void criteriaWithPredicateTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Product.class);
		var root = cq.from(Product.class);
		
		//select p from Product p
		cq.select(root);
		
		//p.productSize.name = :size
		var predicate = root.get("productSize").get("name");
		
		//select p from Product p where p.productSize.name = :size
		cq.where(cb.equal(predicate, "Small"));
		
		show(cq);
	}
	
	

}
