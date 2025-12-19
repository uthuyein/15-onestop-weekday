package com.jdc.mkt.entity.purchases;

import java.time.LocalDate;
import java.time.LocalTime;

import com.jdc.mkt.entity.Supplier;
import com.jdc.mkt.entity.accounts.Admin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_tbl")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private Supplier supplier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Admin admin;
	
	private LocalDate createDate;
	private LocalTime createTime;
	
}
