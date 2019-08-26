package com.asiainfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.asiainfo.entity.QueryUserParam;
import com.asiainfo.entity.User;
import com.asiainfo.enums.LockEnum;
import com.asiainfo.mapper.UserMapper;
import com.asiainfo.util.SqlSessionFactoryDecodeUtil;
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
			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
			
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			User user = userMapper.queryUserById(18);
//			System.out.println(user);
			
			User u = new User();
			u.setUserId(421);
			u.setUserName("g");
//			u.setLocked((byte)1);
//			System.out.println("u1=" + u);
//			int result = userMapper.saveUser(u);
//			sqlSession.commit();
//			System.out.println("u2=" + u);
//			System.out.println("result=" + result);
			
//			int result = userMapper.updateById(u);
			int result = userMapper.deleteById(3);
			sqlSession.commit();
			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test3() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = userMapper.queryUserByName("aaa");
			System.out.println(userList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	@Test
	public void test4() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			Map map = new HashMap();
//			map.put("id", 18);
//			map.put("name", "d");
//			User user = userMapper.queryByCond(map);
//			System.out.println(user);
			
//			User user = userMapper.queryByIdAndName(18, "d");
//			QueryUserParam queryUserParam = new QueryUserParam();
//			queryUserParam.setId(18);
//			queryUserParam.setName("d");
//			User user = userMapper.queryByCondObjParam(queryUserParam);
//			System.out.println(user);
			
//			List<User> list = userMapper.queryUserByName("d");
//			System.out.println(list.get(0));
			
//			User user = userMapper.dynamicCols("user_id,user_name");
//			User user = userMapper.queryByIdSql(1);
//			User user = userMapper.queryByIdSqlPrefix(1);
			User user = userMapper.queryByIdRefidParam("userTable");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
