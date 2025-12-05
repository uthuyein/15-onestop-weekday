package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Size implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String productSize;
	private double productLimit;
	
//	@ElementCollection
//	private List<String> values;
}
