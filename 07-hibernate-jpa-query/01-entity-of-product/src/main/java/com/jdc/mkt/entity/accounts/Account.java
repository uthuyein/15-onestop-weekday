package com.jdc.mkt.entity.accounts;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String username;
	
	@Column(nullable = false,length = 45,unique = true)
	private String loginId;	
	
	@Column(nullable = false,length = 45)
	private String password;
	
	@ColumnDefault("1")
	private boolean active;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	public enum AccountType{
		Customer,Cashier,Admin
	}
}
