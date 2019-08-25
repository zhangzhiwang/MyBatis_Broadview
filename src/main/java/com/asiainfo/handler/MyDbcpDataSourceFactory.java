package com.asiainfo.handler;

import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

/**
 * 自定义数据源
 *
 * @author zhangzhiwang
 * @date Aug 25, 2019 11:51:20 AM
 */
public class MyDbcpDataSourceFactory extends BasicDataSource implements DataSourceFactory {
	private Properties properties;

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProperties(Properties props) {
		properties = props;
	}

	public DataSource getDataSource() {
		DataSource createDataSource = null;
		try {
			createDataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return createDataSource;
	}

}
