package com.jdc.mkt.entity;

import com.jdc.mkt.listener.EnableEntityListener;
import com.jdc.mkt.listener.Times;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import lombok.Data;

@Data
@Entity
//@EntityListeners(EntityListener.class)
public class Teacher implements EnableEntityListener {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Course course;
	
	@Embedded
	private Times times;
	
	
	@PostPersist
	void posPersit() {
		System.out.println("Do something with postPersit");
	}
	
	@PostUpdate
	void postUpdate() {
		System.out.println("Do something with postUpdate");
	}
	
	
	
}
