package com.jdc.mkt.test.jpql;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.Customer;
import com.jdc.mkt.test.JpaFactory;

public class C_QueryResult_With_Params_Test extends JpaFactory{

	@Disabled
	@Test //Index Param = ?1
	void getResultListWithIndexParams() {
		var query = em.createQuery("select c from Customer c where c.contact.primaryPhone like ?1",Customer.class);
		query.setParameter(1, "09-123".concat("%"));
		show(query.getResultList());
	}
	@Test // Name Param = :name
	void getSingleResultWithNameParams() {
		var query = em.createQuery("select count(c) from Customer c where lower(c.username) like  lower(:name)",Long.class);
		query.setParameter("name", "a".concat("%"));
		long count = query.getSingleResult();
		System.out.println("Count :"+count);
	}
	void getResultStream() {
		
		
	}
	void executeUpdate() {}
}
