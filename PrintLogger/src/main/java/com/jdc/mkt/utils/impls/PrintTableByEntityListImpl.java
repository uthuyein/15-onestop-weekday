package com.jdc.mkt.utils.impls;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.inter.PrintTableByEntityListInt;

/**
 * @author MKT
 * @param entityList from getResultList() from entityManager
 * @param entityName 
 * @apiNote will show result table look like sql tables from console .
 */

public class  PrintTableByEntityListImpl extends PrintTableByQueryImpl implements PrintTableByEntityListInt{
	
	public PrintTableByEntityListImpl(Class<?> config) {
		super(config);
	}

	@Override
	public <T>   void printTableByEntity(List<T> entityList, Class<?> entityName) {	
		if (entityList == null || entityList.isEmpty()) {
			System.out.println("There is no data in entityList !");
			return;
		}

		List<String> fieldNames = printEntityColumnNames(entityName);
		int fieldCount = fieldNames.size();
		int[] columnWidths = new int[fieldCount];

		for (int i = 0; i < fieldCount; i++) {
			columnWidths[i] = fieldNames.get(i).length();
		}

		for (T entity : entityList) {
			for (int i = 0; i < fieldCount; i++) {
				Object value = getFieldValue(entity, fieldNames.get(i));
				String str = value != null ? value.toString() : "null";
				columnWidths[i] = Math.max(columnWidths[i], str.length());
			}
		}

		System.out.println("\n   =============   "+entityName.getSimpleName() .toUpperCase()+" TABLE   ==========");
		
		printLine(columnWidths);
		printRow(fieldNames, columnWidths);
		printLine(columnWidths);

		for (T entity : entityList) {
			List<String> values = new ArrayList<String>();
			for (int i = 0; i < fieldCount; i++) {
				Object val = getFieldValue(entity, fieldNames.get(i));
				values.add(val != null ? val.toString() : "null");
			}
			printRow(values, columnWidths);
		}

		printLine(columnWidths);
	}

	private List<String> printEntityColumnNames(Class<?> entityClass) {
		List<String> names = new ArrayList<String>();
		Field[] fields = entityClass.getDeclaredFields();

		if (null != fields) {
			for (int i = 0; i < fields.length; i++) {
				names.add(fields[i].getName());
			}
		}
		return names;
	}

	private  void printLine(int[] widths) {
		for (int width : widths) {
			System.out.print("+");
			System.out.print("-".repeat(width + 2));
		}
		System.out.println("+");
	}

	private  void printRow(List<String> values, int[] widths) {
		for (int i = 0; i < values.size(); i++) {
			System.out.printf("| %-" + widths[i] + "s ", values.get(i));
		}
		System.out.println("|");
	}

	private  Object getFieldValue(Object obj, String fieldName) {
		try {
			Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(obj);
		} catch (Exception e) {
			return "ERR";
		}
	}
	
}
