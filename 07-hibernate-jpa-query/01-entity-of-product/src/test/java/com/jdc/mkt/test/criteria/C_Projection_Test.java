package com.jdc.mkt.test.criteria;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.entity.dto.SelectProduct;
import com.jdc.mkt.test.ShowProduct;

public class C_Projection_Test extends ShowProduct{

	
	
	@Test
	@Order(1)
	void selectIdNameActiveWithMultiSelectTest() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectProduct.class);
		var root = cq.from(Product.class);
		
		cq.select(
				cb.construct(
						SelectProduct.class,
						root.get(Product_.id),
						root.get(Product_.name),
						root.get(Product_.active)
						)
				);
//		cq.multiselect(
//				root.get("id"),
//				root.get("name"),
//				root.get("active")
//				);
		
		showSelectProduct(cq);
	}
}
