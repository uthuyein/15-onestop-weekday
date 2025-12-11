package com.jdc.mkt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "incomes_info_tbl")
public class IncomesInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "incomes_type")
	private IncomesType incomesType;
	
	private LocalDate date;
	private String description;
	
	public enum IncomesType{
		Salary,Bonus,Other
	}
}
