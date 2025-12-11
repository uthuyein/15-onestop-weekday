package com.jdc.mkt;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Office extends Account {

	private String register;
	
	public Office() {
		setAccountType(AccountType.Office);
	}
}
