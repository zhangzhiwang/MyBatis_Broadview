package com.asiainfo.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SqlSessionFactory工具类（具有解密功能）
 *
 * @author zhangzhiwang
 * @date Aug 24, 2019 6:13:01 PM
 */
public class SqlSessionFactoryDecodeUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryDecodeUtil.class);
	private static SqlSessionFactory sqlSessionFactory;

	private SqlSessionFactoryDecodeUtil() {
	}

	public static synchronized SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory != null) {
			return sqlSessionFactory;
		}

		InputStream myBatisConfIn = null;
		InputStream dbIn = null;
		Reader myBatisConfReader = null;
		Reader dbReader = null;
		try {
			myBatisConfIn = Resources.getResourceAsStream("mybatis-config.xml");
			dbIn = Resources.getResourceAsStream("db.properties");
			myBatisConfReader = new InputStreamReader(myBatisConfIn);
			dbReader = new InputStreamReader(dbIn);
			
			Properties properties = new Properties();
			properties.load(dbReader);
			properties.setProperty("password", new String(Base64.getDecoder().decode(properties.getProperty("password"))));
			
			
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sessionFactoryBuilder.build(myBatisConfReader, properties);
			return sqlSessionFactory;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	public static SqlSession getSqlSession() {
		if(sqlSessionFactory == null) {
			getSqlSessionFactory();
		}
		String databaseId = sqlSessionFactory.getConfiguration().getDatabaseId();
		System.out.println("数据库厂商标识：" + databaseId);
		return sqlSessionFactory.openSession();
	}
	
	public static void main(String[] args) {
		System.out.println(new String(Base64.getEncoder().encode("zzw1234".getBytes())));
	}
}
