package com.jdc.mkt.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
public class Category_ {

	public static volatile SingularAttribute<Category, Integer> id;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile SingularAttribute<Category, Boolean> active;
}
