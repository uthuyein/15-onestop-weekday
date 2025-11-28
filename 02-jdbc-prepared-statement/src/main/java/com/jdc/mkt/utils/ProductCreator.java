package com.jdc.mkt.utils;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

public class ProductCreator {

	public static void dropTable() {
		try(var con = getConnection(); 
				var stmt = con.createStatement()){
			stmt.addBatch("drop table  product_tbl");
			stmt.addBatch("drop table category_tbl");
			stmt.executeBatch();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void initData() {
		try(var con = getConnection(); 
				var stmt = con.createStatement()){
			
			stmt.addBatch("insert into category_tbl(name) values ('%s')"
					.formatted("Fruits"));
			stmt.addBatch("insert into category_tbl(name) values ('%s')"
					.formatted("Drinks"));
			
			stmt.addBatch("insert into product_tbl(name,price,category_id) values ('%s',%d,%d)"
					.formatted("Orange",2000,1));
			stmt.addBatch("insert into product_tbl(name,price,category_id) values ('%s',%d,%d)"
					.formatted("Apple",2500,1));
			stmt.addBatch("insert into product_tbl(name,price,category_id) values ('%s',%d,%d)"
					.formatted("Lemon Juice",1500,2));
			
			stmt.executeBatch();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void createTable() {
		try(var con = getConnection(); 
			var stmt = con.createStatement()){
			
			stmt.addBatch("""
					create table if not exists category_tbl(
						id int primary key auto_increment,
						name varchar(45) not null unique
					);
					""");
			stmt.addBatch("""
					create table if not exists product_tbl(
						id int primary key auto_increment,
						name varchar(45) not null,
						price int ,
						category_id int,
						foreign key (category_id) references category_tbl(id)
					);
					""");
			stmt.executeBatch();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
