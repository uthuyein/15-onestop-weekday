package com.jdc.mkt.services;

import java.util.List;

import com.jdc.mkt.entity.Product;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

public class ProductService {

	public int insert(Product p) {
		String sql = "insert into product_tbl(name,price,category_id)values(?,?,?)";
		try(var con = getConnection();
			var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getPrice());
			stmt.setInt(3, p.getCategory().getId());
			return	stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update() {
		String sql = "update product_tbl set name = ?,price = ? where id = ?";
		try(var con = getConnection();
			var stmt = con.prepareStatement(sql)){
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Product> select(Product p) {
		String sql = "";
		try(var con = getConnection();
			var stmt = con.prepareStatement(sql)){
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
