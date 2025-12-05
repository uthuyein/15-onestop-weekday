package com.jdc.mkt;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Student extends Account{

	@ManyToOne
	private Course course;
	
	public Student() {
		setAccountType(AccountType.Student);
	}
}
