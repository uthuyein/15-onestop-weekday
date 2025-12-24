package com.jdc.mkt.test.criteria;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.entity.sales.dto.SelectProductAndSum;
import com.jdc.mkt.test.JpaFactory;

public class E_Aggregate_Test extends JpaFactory{

	@Test
	void selectPNameWithSumTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectProductAndSum.class);
		var root = cq.from(Product.class);
		
		var salePrices = root.get("salePrices");
		var saleDetails = salePrices.get("saleDetails");
		
		cq.select(
				cb.construct(
						SelectProductAndSum.class,
						root.get(Product_.name),
						cb.sum(saleDetails.get("qty"))
						));
		cq.groupBy(root.get(Product_.name));
		
		var query = em.createQuery(cq);
		var list = query.getResultList();
		System.out.println(list);
	}
}
