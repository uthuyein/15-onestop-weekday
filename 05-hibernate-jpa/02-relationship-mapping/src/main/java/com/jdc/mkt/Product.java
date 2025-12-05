package com.jdc.mkt;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45,nullable = false,unique = true)
	private String name;
	
	@ColumnDefault("1")
	private boolean active;
	
	@ManyToOne(optional = false)
	private Category category;
	
	@OneToOne
	private BarCode barcode;
	
	@ManyToMany
	@JoinTable(name = "prod_size_tbl",
		joinColumns = {
				@JoinColumn(name = "prod_id")
		},
		inverseJoinColumns = {
				@JoinColumn(name = "size_id")
		})
	private List<Size> sizes;
	
	
}
