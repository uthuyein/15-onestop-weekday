package com.jdc.mkt;

import com.jdc.mkt.converter.Data;
import com.jdc.mkt.converter.DataConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Entity
@lombok.Data
@EqualsAndHashCode(callSuper = false)
public class Student extends Account{

	@ManyToOne
	private Course course;
	
	@Convert(converter = DataConverter.class)
	private Data data;
	
	public Student() {
		setAccountType(AccountType.Student);
	}
}
