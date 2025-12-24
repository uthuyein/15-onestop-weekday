package com.jdc.mkt.entity;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.entity.dto.SelectProduct;
import com.jdc.mkt.entity.purchases.PurchaseDetail;
import com.jdc.mkt.entity.sales.SalePrice;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_tbl")

@NamedNativeQuery(
		name = "Product.SelectProduct",
		query = "select p.id id,p.name name ,p.active active from product_tbl p",
		resultSetMapping = "productMapping")
		//resultClass = SelectProduct.class)

@SqlResultSetMapping(
		name = "productMapping",
		classes = {
				@ConstructorResult(
						columns = {
								@ColumnResult(name = "p.id"),
								@ColumnResult(name = "p.name"),
								@ColumnResult(name = "p.active")
						},
						targetClass = SelectProduct.class)
		})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,length = 45)
	private String name;
	
	@ColumnDefault("1")
	private boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private ProductSize productSize;
	
	@OneToMany(mappedBy = "product")
	private List<SalePrice> salePrices;
	
	@OneToMany(mappedBy = "product")
	private List<PurchaseDetail> purchaseDetails;
	
}
