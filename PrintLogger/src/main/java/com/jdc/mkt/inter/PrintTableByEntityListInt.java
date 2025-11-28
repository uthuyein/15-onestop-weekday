package com.jdc.mkt.inter;

import java.util.List;

public interface PrintTableByEntityListInt {

	<T>void printTableByEntity(List<T> entityList, Class<?> entityName);
}
