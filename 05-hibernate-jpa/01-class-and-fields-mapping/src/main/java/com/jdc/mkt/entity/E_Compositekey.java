package com.jdc.mkt.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@lombok.Data
@Entity
@Table(name = "composite_tbl")
@IdClass(Values.class)
public class E_Compositekey {

//	@EmbeddedId
//	private Size id;
	@Id
	private String value1;
	@Id
	private String value2;
	
	private String name;
	
	private LocalDate date;
}
