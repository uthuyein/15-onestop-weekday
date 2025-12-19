package com.jdc.mkt.test.jpql;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.sales.dto.SelectProductAndSum;
import com.jdc.mkt.entity.sales.dto.SelectSDateCuNameAndSCount;
import com.jdc.mkt.test.JpaFactory;

public class G_Aggregation_Test extends JpaFactory {
	
	@Test
	@Order(2)
	void selectCustomerAndVoucherCountAndSaleDate() {
		String jpql = """
				select new com.jdc.mkt.entity.sales.dto.SelectSDateCuNameAndSCount(
				s.saleDate,cu.username,count(s.id)) from Customer cu
				join cu.sales s
				group by s.saleDate,cu.username
				order by s.saleDate desc
				""";
		var query = em.createQuery(jpql,SelectSDateCuNameAndSCount.class);
		var list = query.getResultList();
		System.out.println(list);
	}

	@Test
	@Order(1)
	void selectProductAndSum() {
		var jpql = """
				select new com.jdc.mkt.entity.sales.dto.SelectProductAndSum(
				p.name,sum(sd.qty)) from Product p
				join p.salePrices sp
				join sp.saleDetails sd
				group by p.name
				order by p.name desc
				""";
		var query = em.createQuery(jpql,SelectProductAndSum.class);
		var list = query.getResultList();
		System.out.println(list);
	}
}
