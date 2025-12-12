package com.jdc.mkt.entity;

import com.jdc.mkt.listener.EnableEntityListener;
import com.jdc.mkt.listener.Times;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account implements EnableEntityListener{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String loginId;
	private String password;
	private Times times;
}
