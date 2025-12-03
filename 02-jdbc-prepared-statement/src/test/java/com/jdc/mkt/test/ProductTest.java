package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.services.ProductPrcedureService;
import com.jdc.mkt.services.ProductService;

public class ProductTest extends JunitFactory {

	private ProductService service = new ProductService();
	private ProductPrcedureService procedurce = new ProductPrcedureService();
	
	@Test
	void procedurceTest() {
		var p = procedurce.getMaxProduct();
		System.out.println("Max Price Of Product : "+ p.getName());
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Drinks,,",
		",L,",
		",,2000",
		"Fruits,O,"
		
	})
	void selectTest(String category, String product, Integer price) {
		var list = service.select(category, product, null == price ? 0 : price);
		System.out.println("Name :"+ list.getFirst().getName());
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource("PileApple,2500,2")
	void updateTest(String name,int price,int id) {
		var row = service.update(name, price, id);
		assertEquals(1, row);
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({ "Durian,20000,1" })
	void insertTest(String name, int price, int catId) {
		var cat = new Category();
		cat.setId(catId);
		var product = new Product();
		product.setCategory(cat);
		product.setName(name);
		product.setPrice(price);
		int id = service.insert(product);
		assertEquals(4, id);

	}

	
}
