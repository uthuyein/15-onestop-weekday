package com.jdc.mkt.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductSize.class)
public class ProductSize_ {

	public static volatile SingularAttribute<ProductSize, Integer> id;
	public static volatile SingularAttribute<ProductSize, String> name;
	
}
