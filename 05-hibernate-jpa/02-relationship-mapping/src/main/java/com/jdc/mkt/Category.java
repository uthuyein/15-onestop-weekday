package com.jdc.mkt;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 45, nullable = false, unique = true)
	private String name;

	@ColumnDefault("1")
	private boolean active;
	
//	@OneToMany
//	@JoinTable(name = "cat_prod_tbl",
//	joinColumns = {
//			@JoinColumn(name = "cat_id")
//	},
//	inverseJoinColumns = {
//			@JoinColumn(name = "prod_id")
//	})
//	private List<Product> products;
}
