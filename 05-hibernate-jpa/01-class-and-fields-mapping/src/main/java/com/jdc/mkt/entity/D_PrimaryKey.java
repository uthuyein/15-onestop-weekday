package com.jdc.mkt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "primarykey_tbl")
public class D_PrimaryKey {

	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@GeneratedValue(generator = "pkey_seq_gen")
	//@TableGenerator(name = "pkey_tbl_gen",allocationSize = 1,initialValue = 1)
	@SequenceGenerator(name ="pkey_seq_gen",allocationSize = 1,initialValue = 1)
	private int id;
	private String name;
}
