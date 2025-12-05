package com.jdc.mkt;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class BarCode {
	
	@Id
	private int id;
	private String name;
	private boolean active;
	
	@OneToOne(mappedBy = "barcode")
	//@JoinColumn(insertable = false,updatable = false)
	private Product product;
}
