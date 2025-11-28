package com.jdc.mkt.test;

import static com.jdc.mkt.utils.ProductCreator.createTable;
import static com.jdc.mkt.utils.ProductCreator.dropTable;
import static com.jdc.mkt.utils.ProductCreator.initData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import com.jdc.mkt.PrintLogger;
import com.jdc.mkt.utils.DatabaseType;
import com.jdc.mkt.utils.anno.Connector;

@Connector(
		database = DatabaseType.MYSQL, 		
		name = "saleDb", 
		user = "root",
		password = "admin",
		port="3306")
public class JunitFactory {

	
	@BeforeAll
	static void init() {
		dropTable();
		createTable();
		initData();
		System.out.println("Hello junit");
	}
	
	@AfterEach
	void logger() {
		PrintLogger log = PrintLogger.getInstance(JunitFactory.class);
		log.printTableByStringQuery("select * from product_tbl");
	}

}
