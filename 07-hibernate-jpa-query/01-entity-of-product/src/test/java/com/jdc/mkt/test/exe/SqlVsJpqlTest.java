package com.jdc.mkt.test.exe;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.dto.SelectNameEmailStreet;
import com.jdc.mkt.test.JpaFactory;

public class SqlVsJpqlTest extends JpaFactory{

	@Test
	@Order(1)
	void usesqlForSelectNameEmailStreet() {
		var sql = """
				select c.email,cu.username,a.street from customer_tbl cu
				join contact_tbl c on cu.contact_id = c.id 
				join address_tbl a on cu.address_id = a.id
				""";
		var query = em.createNativeQuery(sql, SelectNameEmailStreet.class);
		var list = query.getResultList();
		System.out.println(list);
	}
	
	void usejpqlForSelectNameEmailStreet() {}
}
