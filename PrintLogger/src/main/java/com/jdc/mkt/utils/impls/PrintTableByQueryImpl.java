


package com.jdc.mkt.utils.impls;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.jdc.mkt.inter.PrintTableByQueryInt;
/**
 * @author MKT
 * @param String query
 * @apiNote It is used for table create and drop.
 */
public class PrintTableByQueryImpl implements PrintTableByQueryInt {
	
	private  JdbcConnectorImpl jdbcConnector;
	
	public PrintTableByQueryImpl(Class<?> config) {
		jdbcConnector = new JdbcConnectorImpl(config);		
	}
	
	@Override
	public void PrintTableByupdateQuery(String sql) {		
		try (Statement st = jdbcConnector.getConnection().createStatement()) {

			st.executeUpdate(sql);
			String[] starray = sql.split(" ");
			showResult(starray);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printTableByStringQuery(String query) {
		String[] starray = query.split(" ");
		System.out.println("\n     ******** Table: " + starray[starray.length - 1] + " *******");

		try (Statement st = jdbcConnector.getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY)) {

			ResultSet rs = st.executeQuery(query);
			printTableByResultSet(rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showResult(String[] starray) {
		System.out.println("\n   =============   " + starray[0].toUpperCase() + " TABLE   ==========");		
	
		if (starray[0].equalsIgnoreCase("drop")) {
			System.out.println("\n     ******** Table: " + starray[starray.length - 1].toUpperCase() + " *******");
		}		
		else {
			for (int i = 0; i < starray.length; i++) {
				if (starray[i].equalsIgnoreCase("exists")) {
					System.out.println("\n     ******** Table: " + starray[i + 1].toUpperCase() + " *******");
					break;
				}
			}
		}
	}

	/**
	 * @param resultSet
	 * @apiNote will show result table look like sql tables from console .
	 */
	@Override
	public void printTableByResultSet(ResultSet rs) {
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			int[] columnWidths = new int[columnCount];
			String[] columnNames = new String[columnCount];

			for (int i = 0; i < columnCount; i++) {
				columnNames[i] = metaData.getColumnName(i + 1);
				columnWidths[i] = columnNames[i].length();
			}

			rs.beforeFirst();
			while (rs.next()) {
				for (int i = 0; i < columnCount; i++) {
					Object value = rs.getObject(i + 1);
					if (value != null) {
						columnWidths[i] = Math.max(columnWidths[i], value.toString().length());
					}
				}
			}

			printLine(columnWidths);
			printRow(columnNames, columnWidths);
			printLine(columnWidths);

			rs.beforeFirst();
			while (rs.next()) {
				String[] row = new String[columnCount];
				for (int i = 0; i < columnCount; i++) {
					Object value = rs.getObject(i + 1);
					row[i] = (value != null) ? value.toString() : "null";
				}
				printRow(row, columnWidths);
			}

			printLine(columnWidths);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printLine(int[] widths) {
		for (int width : widths) {
			System.out.print("+");
			System.out.print("-".repeat(width + 2));
		}
		System.out.println("+");
	}

	private void printRow(String[] values, int[] widths) {
		for (int i = 0; i < values.length; i++) {
			System.out.printf("| %-" + widths[i] + "s ", values[i]);
		}
		System.out.println("|");
	}

}
