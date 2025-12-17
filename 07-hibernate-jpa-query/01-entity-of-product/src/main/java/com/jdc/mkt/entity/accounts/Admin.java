package com.jdc.mkt.entity.accounts;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "admin_tbl")
@EqualsAndHashCode(callSuper = false)
public class Admin extends Account{
	
	public Admin() {
		setType(Type.Admin);
	}
}
