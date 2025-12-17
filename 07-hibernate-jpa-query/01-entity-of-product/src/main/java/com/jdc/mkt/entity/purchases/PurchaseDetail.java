package com.jdc.mkt.entity.purchases;

import com.jdc.mkt.entity.Product;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_detail_tbl")
public class PurchaseDetail {

	@EmbeddedId
	private PurchaseDetailPk id;
	
	@ManyToOne
	@MapsId("productId")
	private Product product;
	
	@ManyToOne
	@MapsId("purchaseId")
	private Purchase purchase;
	
	private Double price;
	private int qty;
}
