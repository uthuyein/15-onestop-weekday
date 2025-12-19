package com.jdc.mkt.entity.sales;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_detail_tbl")
public class SaleDetail {

	@EmbeddedId
	private SaleDetailPk id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Sale sale;
	
	@ManyToOne
	private SalePrice salePrice;
	
	private int qty;
	private double subTotal;
}
