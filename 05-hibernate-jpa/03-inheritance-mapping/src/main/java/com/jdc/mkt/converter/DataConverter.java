package com.jdc.mkt.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class DataConverter implements AttributeConverter<Data, String>{

	@Override
	public String convertToDatabaseColumn(Data data) {
		return data.toString();
	}

	@Override
	public Data convertToEntityAttribute(String data) {
		if(null != data) {
			var array = data.split(":");
			var dt = new Data();
			dt.setKey(Integer.parseInt(array[0]));
			dt.setValue(array[1]);
			return dt;
		}
		return null;
	}

}
