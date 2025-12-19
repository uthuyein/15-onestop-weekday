package com.jdc.mkt.entity.sales;

import java.time.LocalDate;
import java.util.List;

import com.jdc.mkt.entity.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_price_tbl")
public class SalePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private Double price;	
	private LocalDate createDate;
	
	@ManyToOne
	private Product product;
	
	@OneToMany(mappedBy = "salePrice")
	private List<SaleDetail> saleDetails;
	
}
