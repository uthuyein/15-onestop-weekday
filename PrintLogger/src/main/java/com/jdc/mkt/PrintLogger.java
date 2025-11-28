package com.jdc.mkt;

import com.jdc.mkt.inter.PrintTableByEntityListInt;
import com.jdc.mkt.inter.PrintTableByQueryInt;
import com.jdc.mkt.inter.PrintTableByResultSetInt;
import com.jdc.mkt.utils.impls.PrintTableByEntityListImpl;

public class PrintLogger extends PrintTableByEntityListImpl implements PrintTableByEntityListInt,PrintTableByQueryInt,PrintTableByResultSetInt {

	private static PrintLogger instance;
	
	private PrintLogger(Class<?> config) {
		super(config);
		
	}
	
	public static PrintLogger getInstance(Class<?> config) {
		if (instance == null) {
			instance = new PrintLogger(config);
		}
		return instance;
	}
}
