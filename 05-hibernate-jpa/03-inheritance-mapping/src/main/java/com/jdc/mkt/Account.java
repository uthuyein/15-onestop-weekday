package com.jdc.mkt;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(nullable = false,length = 45)
	private String username;
	
	@Column(nullable = false,length = 45,unique = true)
	private String loginId;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	public enum AccountType {
		Office,Teacher,Student
	}
}
