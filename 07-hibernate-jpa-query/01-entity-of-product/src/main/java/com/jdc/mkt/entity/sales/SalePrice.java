package com.jdc.mkt.entity.sales;

import java.time.LocalDate;
import java.util.UUID;

import com.jdc.mkt.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_price_tbl")
public class SalePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	private Product product;
	
	private Double price;
	
	private LocalDate createDate;
}
