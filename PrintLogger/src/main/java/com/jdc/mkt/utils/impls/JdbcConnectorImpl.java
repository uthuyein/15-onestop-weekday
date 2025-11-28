package com.jdc.mkt.utils.impls;

import java.sql.Connection;
import java.sql.DriverManager;

import com.jdc.mkt.utils.DatabaseType;
import com.jdc.mkt.utils.anno.Connector;
/**
 * @author MKT
 * @param configClass the class annotated with @Connector
 * @return a Connection object
 * @throws Exception if the connection cannot be established
 */
final class JdbcConnectorImpl {
	
	private static ConnectionData connectionData;
	private static Class<?> configClass;

	private static record ConnectionData(DatabaseType type, String className, String url, String user,
			String password) {
	}

	JdbcConnectorImpl(Class<?> config) {
		configClass = config;

	}

	protected Connector getConnector() throws RuntimeException {
		if (configClass.isAnnotationPresent(Connector.class)) {
			Connector connector = configClass.getAnnotation(Connector.class);
			return connector;
		}
		throw new RuntimeException("Connector annotation not present on class");

	}

	public Connection getConnection() throws RuntimeException {
		try {
			
			if (null == connectionData) {
				var connector = getConnector();
				if (connector != null) {
					var dbType = connector.database();
					var url = dbType.getUrl()+connector.port()+"/" + connector.name();
					var className = dbType.getDriverClassName();
					connectionData = new ConnectionData(dbType, className, url, connector.user(), connector.password());
				}			
			}
		
			return  DriverManager.getConnection(connectionData.url(), connectionData.user(),
					connectionData.password());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Connector annotation not present on class");
		}

	}
	
}
