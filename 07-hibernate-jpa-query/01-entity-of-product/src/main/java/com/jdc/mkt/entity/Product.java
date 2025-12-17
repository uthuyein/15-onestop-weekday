package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@ColumnDefault("1")
	private boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private ProductSize productSize;
	
}
