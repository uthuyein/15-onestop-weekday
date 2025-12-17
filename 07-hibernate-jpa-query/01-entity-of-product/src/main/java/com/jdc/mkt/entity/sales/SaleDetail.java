package com.jdc.mkt.entity.sales;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_detail_tbl")
public class SaleDetail {

	@EmbeddedId
	private SaleDetailPk id;
	
	@ManyToOne
	private Sale sale;
	
	@ManyToOne
	private SalePrice salePrice;
	
	private int qty;
	private double subTotal;
}
