package com.jdc.mkt.services;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.entity.Product;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

public class ProductService {

	public int insert(Product p) {
		String sql = "insert into product_tbl(name,price,category_id)values(?,?,?)";
		try(var con = getConnection();
			var stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getPrice());
			stmt.setInt(3, p.getCategory().getId());
			stmt.executeUpdate();
			
			var rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(String name,int price,int id) {
		String sql = "update product_tbl set name = ?,price = ? where id = ?";
		try(var con = getConnection();
			var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, name);
			stmt.setInt(2, price);
			stmt.setInt(3, id);
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Product> select(String category,String name ,int price) {
		List<Object> temp = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		
		StringBuffer sb = new StringBuffer("""
				select * from product_tbl p 
				join category_tbl c on p.category_id = c.id 
				where 1=1
				""");
		
		
		
		if(null != name) {
			sb.append(" and lower(p.name) like lower(?)");
			temp.add(name.concat("%"));
		}
		
		if(price > 0) {
			sb.append( " and p.price = ?");
			temp.add(price);
		}
		
		if(null != category) {
			sb.append( " and c.name = ?");
			temp.add(category);
		}
		try(var con = getConnection();
			var stmt = con.prepareStatement(sb.toString())){
			
			for(int i = 0 ; i < temp.size() ; i ++) {
				stmt.setObject(i+1, temp.get(i));
			}
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				
				products.add(p);
				
			}
						
		}catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
