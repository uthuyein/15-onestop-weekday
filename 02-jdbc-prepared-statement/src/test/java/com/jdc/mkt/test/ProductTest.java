package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.services.ProductService;

public class ProductTest extends JunitFactory {

	private ProductService service = new ProductService();

	
	@ParameterizedTest
	@CsvSource({ "Durian,20000,1" })
	void insertTest(String name, int price, int catId) {
		var cat = new Category();
		cat.setId(catId);
		var product = new Product();
		product.setCategory(cat);
		product.setName(name);
		product.setPrice(price);
		int row = service.insert(product);
		assertEquals(1, row);

	}

	@Test
	void selectTest(String category, String product, int price) {
	}
}
