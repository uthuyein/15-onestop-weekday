package com.jdc.mkt.entity.customers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@Table(name = "address_tbl")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@NonNull
	@Column(nullable = false,length = 45)
	private String state;
	@NonNull
	@Column(nullable = false,length = 45)
	private String township;
	@NonNull
	@Column(nullable = false)
	private String street;
}
