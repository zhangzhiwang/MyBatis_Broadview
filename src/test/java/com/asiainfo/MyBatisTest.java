package com.asiainfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.asiainfo.entity.Course;
import com.asiainfo.entity.ProcedureParam;
import com.asiainfo.entity.QueryUserParam;
import com.asiainfo.entity.StuCourse;
import com.asiainfo.entity.Student;
import com.asiainfo.entity.TFile;
import com.asiainfo.entity.StudentCard;
import com.asiainfo.entity.User;
import com.asiainfo.enums.LockEnum;
import com.asiainfo.mapper.StudentMapper;
import com.asiainfo.mapper.TFileMapper;
import com.asiainfo.mapper.UserMapper;
import com.asiainfo.util.SqlSessionFactoryDecodeUtil;
import com.asiainfo.util.SqlSessionFactoryUtil;

/**
 * Mybatis测试
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
			if (sqlSession != null) {
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

//			User u = new User();
//			u.setUserName("j");
//			u.setLocked(LockEnum.LOCKED);
//			System.out.println("u1=" + u);
//			int result = userMapper.saveUser(u);
//			sqlSession.commit();
//			System.out.println("u2=" + u);
//			System.out.println("result=" + result);

			User user = userMapper.queryUserById(924);
			System.out.println(user);

//			int result = userMapper.updateById(u);
//			int result = userMapper.deleteById(3);
//			sqlSession.commit();
//			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
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
			if (sqlSession != null) {
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
			Map map = new HashMap();
			map.put("id", 18);
			map.put("name", "d");
			User user = userMapper.queryByCond(map);
			System.out.println(user);

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
//			User user = userMapper.queryByIdRefidParam("userTable");
//			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void test5() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//			User user = new User();
//			user.setUserName("g");
//			user.setPassword("1");
//			
//			userMapper.saveUser(user);
//			sqlSession.commit();

//			User user = userMapper.queryByIdSql(521);
			User user = new User();
			user.setUserName("tom");
			List<User> list = userMapper.queryByCond5(user);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void test6() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			User user = new User();
			user.setUserId(624);
			user.setUserName("h2");
			user.setLastIp("128");

//			userMapper.insertByCond(user);
//			userMapper.update2(user);
//			sqlSession.commit();
//			List<User> list = userMapper.queryByCond6(Arrays.asList(1,2));
			List<User> list = userMapper.queryByCond7("om", "12");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void test7() {
		SqlSession sqlSession = null;
		try {
			// 1、SqlSessionFactoryBuilder读取MyBatis全局配置文件来构造SqlSessionFactory
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);// SqlSessionFactory是接口，其子类DefaultSqlSessionFactory持有Configuration对象，该对象是MyBatis全局配置文件以java对象在内存中的表示形式

			// 2、通过SqlSessionFactory获取SqlSession
			sqlSession = sqlSessionFactory.openSession();
//			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
			System.out.println("sqlSession1=" + sqlSession);
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			System.out.println("开始查询...");
			Student student = studentMapper.queryByStuId(1);
			System.out.println(student);
			System.out.println("开始第二次查询...");
			Student student2 = studentMapper.queryByStuId(1);
			System.out.println(student2);
			System.out.println("开始第三次查询...");
			
			// 1、SqlSessionFactoryBuilder读取MyBatis全局配置文件来构造SqlSessionFactory
			InputStream inputStream2 = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder2 = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory2 = sqlSessionFactoryBuilder2.build(inputStream2);// SqlSessionFactory是接口，其子类DefaultSqlSessionFactory持有Configuration对象，该对象是MyBatis全局配置文件以java对象在内存中的表示形式

			// 2、通过SqlSessionFactory获取SqlSession
			SqlSession sqlSession2 = sqlSessionFactory2.openSession();
			System.out.println("sqlSession1==sqlSession2? " + (sqlSession == sqlSession2));
			System.out.println("sqlSession2=" + sqlSession);
			StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
			Student student3 = studentMapper2.queryByStuId(1);
			System.out.println(student3);

//			System.out.println("-----------------------");
//			Thread.sleep(2000);
//			
//			List<StuCourse> stuCourseList = student.getStuCourseList();
//			System.out.println("-----------------------");
//			Thread.sleep(2000);
//			
//			Course course = stuCourseList.get(0).getCourse();
//			System.out.println("-----------------------");
//			Thread.sleep(2000);
//			
//			StudentCard studentCard = student.getStudentCard();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void test8() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
			TFileMapper fileMapper = sqlSession.getMapper(TFileMapper.class);

			File file = new File("/Users/zhangzhiwang/Desktop/settings.xml");
			InputStream in = new FileInputStream(file);
			System.out.println("before:file.length()=" + file.length());
			byte[] bs = new byte[(int) file.length()];
			in.read(bs);
			in.close();

			TFile t = new TFile();
			t.setFileBytes(bs);
			fileMapper.save(t);

			TFile tFile = fileMapper.queryById(t.getId());
			System.out.println(tFile.getFileBytes().length);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void test9() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryDecodeUtil.getSqlSession();
//			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			TFileMapper mapper = sqlSession.getMapper(TFileMapper.class);
//			ProcedureParam procedureParam = new ProcedureParam();
//			procedureParam.setpName("a");
//			mapper.callProcedure(procedureParam);
//			
//			System.out.println(procedureParam.getResult() + " | " + procedureParam.getNow());
			List<TFile> tFiles = mapper.queryByYearWithPage("2018", new RowBounds(0, 3));
			System.out.println(tFiles.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
