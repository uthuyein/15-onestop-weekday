package com.jdc.mkt.entity.sales;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SaleDetailPk {

	@Column(name = "sale_id",insertable = false,updatable = false)
	private UUID saleId;
	
	@Column(name = "salePrice_id",insertable = false,updatable = false)
	private UUID salePriceId;
	
	private LocalDate saleDate;
	private LocalTime saleTime;
}
