package com.jdc.mkt.test.all.exe;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.purchases.SelectCNamePNamePSize;
import com.jdc.mkt.test.JpaFactory;

public class A_PurchaseTest extends JpaFactory{

	@Test
	@Order(1)
	void selectCNamePNamePSizeBySupplierWithSql() {
		var sql = """
				select distinct c.name,p.name,s.name from category_tbl c
				join product_tbl p on p.category_id = c.id
				join product_size_tbl s on p.productSize_id = s.id
				join purchase_detail_tbl pd on pd.product_id = p.id
				join purchase_tbl pr on pd.purchase_id = pr.id 
				join supplier_tbl su on pr.supplier_id = su.id
				where su.name = :name
				""";
		
		var query = em.createNativeQuery(sql, SelectCNamePNamePSize.class);
		query.setParameter("name", "John Doe");
		var list = query.getResultList();
		System.out.println(list);
	}
	
	@Test
	@Order(2)
	void selectCNamePNamePSizeBySupplierWithJpql() {
		var jpql = """
				select distinct p.name,p.category.name,p.productSize.name
				from Product p join p.purchaseDetails pd 
				where pd.purchase.supplier.name = :name
				""";
		var query = em.createQuery(jpql, SelectCNamePNamePSize.class);
		query.setParameter("name", "John Doe");
		var list = query.getResultList();
		System.out.println(list);
				
	}
	
	@Test
	@Order(3)
	void selectCNamePNamePSizeBySupplierWithCriteria() {
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(SelectCNamePNamePSize.class);
		var root = cq.from(Product.class);
		
		var pd = root.join("purchaseDetails");
		var sup = pd.join("purchase").get("supplier");
		
		 cq.select(cb.construct(
				SelectCNamePNamePSize.class,
				root.get("name"),
				root.get("category").get("name"),
				root.get("productSize").get("name")));
		
		cq.where(cb.equal(sup.get("name"), "John Doe"));
		var cqd = cq.distinct(!cq.isDistinct());
		
		var query = em.createQuery(cqd);
		var list = query.getResultList();
		System.out.println(list);
		
		
	}
}
