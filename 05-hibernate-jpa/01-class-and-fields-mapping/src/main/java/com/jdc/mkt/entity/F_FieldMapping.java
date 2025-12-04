package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "field_tbl")
public class F_FieldMapping {

	@Id
	private int id;
	
	@Column(nullable = false,length = 45,unique = true)
	private String name;
	
	private LocalDate date;
	private LocalTime time;
	private LocalDateTime dtTime;
	
	@Temporal(TemporalType.DATE)
	private Date utiDate;
	
	@Temporal(TemporalType.TIME)
	private Calendar calendar;
	
	@Column(columnDefinition = "tinyint(1) not null default 1")
	private boolean active;
	
	@Transient
	private  boolean checker;
	
	@Enumerated(EnumType.STRING)
	private Days day;
	
	public enum Days{
		Mon,Tue,Wed,Thur,Fri,Sat,Sun
	}
	
}
