package com.jdc.mkt.test.criteria;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.test.ShowProduct;

public class D_Join_Test extends ShowProduct{
	
	@Test
	@Order(2)
	/*
	 * select p.name from category_tbl c 
	 * join product_tbl p on p.category_id = c.id
	 * join p.productSize_id ps on p.productSize_id = ps.id
	 * where ps.name = :name
	 */
	void selectProductByPSize() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(String.class);
		var root = cq.from(Category.class);
		
		var products = root.join("products");
		cq.select(products.get("name"));
		
		cq.where(cb.equal(products.get("productSize").get("name") , "Small"));
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Disabled
	@Order(1)
	void selectProductByCName() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Product.class);
		var root = cq.from(Product.class);
		
		var category = root.join(Product_.category);
		cq.select(root);
		
		cq.where(cb.equal(category.get(Category_.name), "CoolDrinks"));
		
		show(cq);
	}
}
