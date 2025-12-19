package com.jdc.mkt.entity.sales;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.jdc.mkt.entity.accounts.Cashier;
import com.jdc.mkt.entity.customers.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_tbl")
public class Sale {

	@Id
	@GeneratedValue( strategy =  GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer;
	
	@ManyToOne(optional = false)
	private Cashier cashier;
	
	@OneToMany(mappedBy = "sale")
	private List<SaleDetail> saleDetails;
	
	private LocalDate saleDate;
	private LocalTime saleTime;
}
