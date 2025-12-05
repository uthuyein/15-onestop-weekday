package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_tbl")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	private LocalDate dob;
	
	@ManyToOne
	private Address address;
	
	@ManyToOne
	private School school;
	
	public enum Gender{
		Male,Female,Other
	}
}
