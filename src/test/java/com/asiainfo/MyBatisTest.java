package com.asiainfo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.asiainfo.entity.User;
import com.asiainfo.mapper.UserMapper;
import com.asiainfo.util.SqlSessionFactoryUtil;

/**
 * 	Mybatis测试
 *
 * @author zhangzhiwang
 * @date Aug 24, 2019 4:11:11 PM
 */
public class MyBatisTest {
	@Test
	public void test1() {
		SqlSession sqlSession = null;
		try {
			// 1、SqlSessionFactoryBuilder读取MyBatis全局配置文件来构造SqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);// SqlSessionFactory是接口，其子类DefaultSqlSessionFactory持有Configuration对象，该对象是MyBatis全局配置文件以java对象在内存中的表示形式
			
			// 2、通过SqlSessionFactory获取SqlSession
			sqlSession = sqlSessionFactory.openSession();
			
//		// 3、通过SqlSession获取Mapper
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		// 4、调用Mapper的方法
//		User user = userMapper.queryUserById(1);
//		System.out.println(user);
			
			// MyBatis遗留iBatis的方式
			User user2 = sqlSession.selectOne("com.asiainfo.mapper.UserMapper.queryUserById", 1);
			System.out.println(user2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test2() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.queryUserById(2);
			System.out.println(user);
			
			User u = new User();
			u.setUserName("aaa");
			userMapper.saveUser(u);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
