package com.jdc.mkt;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Teacher extends Account {

	private String teaching;
	
	public Teacher() {
		setAccountType(AccountType.Teacher);
	}
}
