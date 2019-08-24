package com.asiainfo;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.asiainfo.entity.User;
import com.asiainfo.mapper.UserMapper;

/**
 * 以java代码的形式对MyBatis进行全局的配置，作用类似于MyBatis的全局配置文件
 *
 * @author zhangzhiwang
 * @date Aug 24, 2019 4:24:41 PM
 */
public class MyBatisWholeConfig {
	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			// 1、构造数据源DataSource
			/**
			 * 相当于MyBatis全局配置文件中的：
			 * <dataSource type="POOLED">
					<property name="driver" value="com.mysql.jdbc.Driver"/>
					<property name="url" value="jdbc:mysql://localhost:3306/sampledb"/>
					<property name="username" value="root"/>
					<property name="password" value="zzw1234"/>
				</dataSource>
			 */
			PooledDataSource pooledDataSource = new PooledDataSource();
			pooledDataSource.setDriver("com.mysql.jdbc.Driver");
			pooledDataSource.setUrl("jdbc:mysql://localhost:3306/sampledb");
			pooledDataSource.setUsername("root");
			pooledDataSource.setPassword("zzw1234");
			
			// 2、构建数据库事务方式
			/**
			 * 相当于MyBatis全局配置文件中的：
			 * <transactionManager type="JDBC"></transactionManager>
			 */
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			
			// 3、创建环境信息
			/**
			 * 相当于MyBatis全局配置文件中的：
			 * <environment id="development">
				<transactionManager type="JDBC"></transactionManager>
				
				<dataSource type="POOLED">
					<property name="driver" value="com.mysql.jdbc.Driver"/>
					<property name="url" value="jdbc:mysql://localhost:3306/sampledb"/>
					<property name="username" value="root"/>
					<property name="password" value="zzw1234"/>
				</dataSource>
			</environment>
			 */
			Environment environment = new Environment("development", transactionFactory, pooledDataSource);
			
			// 4、构建Configuration对象（Configuration对象是MyBatis的全局配置文件在内存中的表示）
			Configuration configuration = new Configuration(environment);
			
			// 5、设置别名
			/**
			 * 相当于MyBatis全局配置文件中的：
			 * <typeAliases>
			<typeAlias type="com.asiainfo.entity.User" alias="User"/>
</typeAliases>
			 */
			configuration.getTypeAliasRegistry().registerAlias("User", User.class);
			
			// 6、配置映射器
			/**
			 * 相当于MyBatis全局配置文件中的：
			 <mappers>
			<mapper resource="classpath:mapper/UserMapper.xml"/>
</mappers>
			 */
			configuration.addMapper(UserMapper.class);
			
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configuration);
			sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.queryUserById(1);
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
