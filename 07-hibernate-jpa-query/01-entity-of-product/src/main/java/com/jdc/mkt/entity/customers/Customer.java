package com.jdc.mkt.entity.customers;

import java.util.List;

import com.jdc.mkt.entity.accounts.Account;
import com.jdc.mkt.entity.sales.Sale;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "customer_tbl")
@EqualsAndHashCode(callSuper = false)
@NamedQuery(
		name = "Customer.selectCustomerByNameLike",
		query = "select c from Customer c where lower(c.username) like lower(?1)")
@NamedQuery(
		name = "Customer.selectCustomerByEmail",
		query = "select cu from Customer cu where cu.contact.email = ?1")
public class Customer extends Account{

	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Address address;
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Contact contact;
	
	@OneToMany(mappedBy = "customer")
	private List<Sale> sales;
	
	public Customer() {
		setAccountType(AccountType.Customer);
	}
	
	public enum MemberType{
		NoMember,Silver,Gold,Diamond
	}
	
}
