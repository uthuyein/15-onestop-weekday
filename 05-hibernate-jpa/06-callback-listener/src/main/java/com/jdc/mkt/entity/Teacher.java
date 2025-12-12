package com.jdc.mkt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Teacher {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Course course;
}
