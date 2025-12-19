package com.jdc.mkt.test.sql;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.dto.SelectProduct;
import com.jdc.mkt.test.JpaFactory;

public class A_sqlTest extends JpaFactory {

	@Test
	@Order(3)
	void staticQueryTest() {	
		var query = em.createNamedQuery("Product.SelectProduct",SelectProduct.class);
		var list = query.getResultList();
		
		System.out.println(list);
	}
	
	@Test
	@Order(2)
	void dynamicQueryWithResultSetMappingTest() {
		var sql = """
				select p.id,p.name,p.active from product_tbl p
				join product_size_tbl s on p.productSize_id = s.id
				where s.name = :name
				""";
		var query = em.createNativeQuery(sql,"productMapping");
		query.setParameter("name", "Small");
		var list = query.getResultList();
		
		System.out.println(list);
	}
	@Test
	@Order(1)
	void dynamicQueryWithResultClassTest() {
		var sql = "select * from product_tbl ";
		var query = em.createNativeQuery(sql,Product.class);
		var list = query.getResultList();
		
		System.out.println(list);
	}
}
