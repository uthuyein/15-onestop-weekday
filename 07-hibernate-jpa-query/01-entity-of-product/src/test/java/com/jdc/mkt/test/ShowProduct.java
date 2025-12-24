package com.jdc.mkt.test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.SelectProduct;

import jakarta.persistence.criteria.CriteriaQuery;

public class ShowProduct extends JpaFactory{

	protected void show(CriteriaQuery<Product> cq) {
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.stream().forEach(p -> System.out.println(p.getName()));
	}
	
	protected void showSelectProduct(CriteriaQuery<SelectProduct> cq) {
		var query = em.createQuery(cq);
		var list = query.getResultList();
		list.stream().forEach(p -> System.out.println(p.name()));
	}
}
