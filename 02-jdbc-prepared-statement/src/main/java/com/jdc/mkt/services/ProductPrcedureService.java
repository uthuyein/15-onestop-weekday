package com.jdc.mkt.services;

import static com.jdc.mkt.utils.ConnectionManager.getConnection;


import com.jdc.mkt.entity.Product;

public class ProductPrcedureService {

	/*
	 * delimiter //
		create procedure getMaxProduct()
		begin
		 select * from product_tbl 
		 where price = (select max(p.price) from product_tbl p);
		 end//
		
		 delimiter ;
		call getMaxProduct()
	 */
	
	public Product getMaxProduct() {
		String sql = "call getMaxProduct()";
		try(var con = getConnection();
			var stmt = con.prepareCall(sql)){
			
			var rs = stmt.executeQuery();
			while(rs.next()) {
				var p = new Product();
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				return p;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
