package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String state;
	@NonNull
	private String township;
	@NonNull
	private String street;
	
	@OneToMany(mappedBy = "address", 
			orphanRemoval = true,
			cascade = {CascadeType.PERSIST,CascadeType.DETACH})
	private List<Person> persons = new ArrayList<Person>();
	
	
	public void addPerson(Person...persons) {
		for(Person p : persons) {
			p.setAddress(this);
			this.persons.add(p);
		}
	}
}





