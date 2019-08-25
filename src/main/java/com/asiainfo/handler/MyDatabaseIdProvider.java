package com.asiainfo.handler;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;

/**
 * 自定义数据库厂商标识
 *
 * @author zhangzhiwang
 * @date Aug 25, 2019 12:55:09 PM
 */
public class MyDatabaseIdProvider implements DatabaseIdProvider {
	private Properties properties;
	
	public void setProperties(Properties p) {
		properties = p;
	}

	public String getDatabaseId(DataSource dataSource) throws SQLException {
		System.out.println("自定义的MyDatabaseIdProvider");
		String databaseProductName = dataSource.getConnection().getMetaData().getDatabaseProductName();
		String dbId = (String) properties.get(databaseProductName);
		return dbId;
	}

}
