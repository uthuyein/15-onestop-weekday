package com.jdc.mkt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contact_tbl")
@SecondaryTable(name = "address_tbl")
@SecondaryTable(name = "email_tbl")
public class Contact {

	@Id
	private int id;

	@Column(table = "address_tbl")
	private String state;
	@Column(table = "address_tbl")
	private String township;
	@Column(table = "address_tbl")
	private String street;

	@Column(table = "email_tbl")
	private String email;

	private String prmaryContact;
	private String secondaryContact;
}
