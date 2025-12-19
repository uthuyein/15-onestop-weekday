package com.jdc.mkt.entity.sales.dto;

import java.time.LocalDate;

public record SelectSDateCuNameAndSCount(
		LocalDate date,
		String name,
		long count
		) {

}
