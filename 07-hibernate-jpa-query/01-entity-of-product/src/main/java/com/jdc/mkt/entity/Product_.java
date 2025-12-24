package com.jdc.mkt.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ {

	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Boolean> active;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, ProductSize> productSize;
}
