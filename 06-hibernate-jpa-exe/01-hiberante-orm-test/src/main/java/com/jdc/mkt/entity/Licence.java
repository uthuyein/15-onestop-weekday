package com.jdc.mkt.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "licence_tbl")
public class Licence {

	@EmbeddedId
	private LicencePk id;
	
	@OneToOne
	private Student student;
	
	@Enumerated(EnumType.STRING)
	private BloodType bloodType;
	
	@Enumerated(EnumType.STRING)
	private LicenceType licenceType;
	
	public enum BloodType{
		A,B,AB,O
	}
	public enum LicenceType{
		A,B,C,D,E
	}
}
