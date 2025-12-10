package com.jdc.mkt.converter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Data {

	private int key;
	private String value;

	@Override
	public String toString() {
		return key + ":" + value;
	}

}
