package com.jdc.mkt.entity.accounts;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "cashier_tbl")
@EqualsAndHashCode(callSuper = false)
public class Cashier extends Account{
	
	public Cashier() {		
		setAccountType(AccountType.Cashier);
	}
}
