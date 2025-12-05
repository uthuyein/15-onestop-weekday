package com.jdc.mkt;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class BarCodePk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "product_id",insertable = false,updatable = false)
	private int productId;
	private int categoryId;
	private int sizeId;
}
