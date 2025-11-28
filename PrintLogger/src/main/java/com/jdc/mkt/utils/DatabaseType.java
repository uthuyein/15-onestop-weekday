package com.jdc.mkt.utils;

public enum DatabaseType {

	MYSQL("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:"),
	PSQL("org.postgresql.Driver","jdbc:postgresql://localhost:"),
	H2("org.h2.Driver","jdbc:h2:mem:"),
	HSQL("org.hsqldb.jdbc.JDBCDriver","jdbc:hsql:mem://localhost:");
	
	private String driverClassName;
	private String dbName;
	private String userName;
	private String password;
	private String url;
	private String port;
	
	private DatabaseType(String driverClassName,String url) {
		this.driverClassName = driverClassName;
		this.url = url;
	} 

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public String getDbName() {
		return dbName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
