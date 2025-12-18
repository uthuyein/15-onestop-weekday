package com.jdc.mkt.test.jpql;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.customers.Customer;
import com.jdc.mkt.entity.customers.Customer.MemberType;
import com.jdc.mkt.test.JpaFactory;

public class C_QueryResult_With_Params_Test extends JpaFactory {

	@Disabled
	@Test // Index Param = ?1
	void getResultListWithIndexParams() {
		var query = em.createQuery("select c from Customer c where c.contact.primaryPhone like ?1", Customer.class);
		query.setParameter(1, "09-123".concat("%"));
		show(query.getResultList());
	}

	@Disabled
	@Test // Name Param = :name
	void getSingleResultWithNameParams() {
		var query = em.createQuery("select count(c) from Customer c where lower(c.username) like  lower(:name)",
				Long.class);
		query.setParameter("name", "a".concat("%"));
		long count = query.getSingleResult();
		System.out.println("Count :" + count);
	}

	@Test
	@Disabled
	void getResultStream() {
		String param = "herry11";
		var query = em.createQuery("select c from Customer c where c.loginId = :login", Customer.class);
		query.setParameter("login", param);
		Customer cu = query.getResultStream().filter(c -> c.getLoginId().equals(param)).findFirst().orElse(null);
		System.out.println(cu.getUsername());
	}

	@Test
	void executeUpdate() {
		var query = em.createQuery("update Customer c set c.memberType = :change where c.memberType = :origin");
		query.setParameter("origin", MemberType.Silver);
		query.setParameter("change", MemberType.Gold);
		em.getTransaction().begin();
		var row = query.executeUpdate();
		em.getTransaction().commit();
		
		System.out.println("Row Count ::: "+row);
	}
}
