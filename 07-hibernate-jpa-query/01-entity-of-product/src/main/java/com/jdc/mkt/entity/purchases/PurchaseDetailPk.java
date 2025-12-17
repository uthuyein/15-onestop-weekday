package com.jdc.mkt.entity.purchases;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PurchaseDetailPk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	private int productId;
	@Column(name = "purchase_id")
	private int purchaseId;
}
