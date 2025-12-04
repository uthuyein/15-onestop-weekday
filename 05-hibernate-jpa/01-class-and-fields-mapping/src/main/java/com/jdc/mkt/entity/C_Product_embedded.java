package com.jdc.mkt.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")
public class C_Product_embedded {

	@Id
	private int id;
	private String name;
	private int price;
	@Embedded
	private Size size;
}
