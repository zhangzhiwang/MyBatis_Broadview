package com.asiainfo.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SqlSessionFactory工具类
 *
 * @author zhangzhiwang
 * @date Aug 24, 2019 6:13:01 PM
 */
public class SqlSessionFactoryUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(SqlSessionFactoryUtil.class);
	private static SqlSessionFactory sqlSessionFactory;

	private SqlSessionFactoryUtil() {
	}

	public static synchronized SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory != null) {
			return sqlSessionFactory;
		}

		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
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
		
		return sqlSessionFactory.openSession();
	}
}
