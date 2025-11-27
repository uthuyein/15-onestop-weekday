package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.jdc.mkt.utils.ConnectionManager.*;

public class JunitFactory {

	
	@BeforeAll
	static void init() {
		createTable();
	}
	
	@Test
	void test() {}
}
