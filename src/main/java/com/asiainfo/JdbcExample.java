package com.asiainfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.asiainfo.entity.User;

/**
 * 传统用jdbc方式访问数据库
 *
 * @author zhangzhiwang
 * @date Aug 22, 2019 10:12:33 AM
 */
public class JdbcExample {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			// 1、获取数据库连接
			// 1.1 设置mysql驱动
			Class.forName("com.mysql.jdbc.Driver"); //要想引入次驱动需要引入mysql驱动jar包
			// 1.2 设置数据库url
			String url = "jdbc:mysql://localhost:3306/sampledb";
			// 1.3 设置用户名
			String user = "root";
			// 1.4 设置密码
			String password = "zzw1234";
			connection = DriverManager.getConnection(url, user, password);

			// 2、准备PreparedStatement，并设置sql语句和参数
			prepareStatement = connection.prepareStatement("select user_id,user_name from t_user where user_id=?");
			prepareStatement.setInt(1, 1);

			// 3、执行sql并返回结果集ResultSet
			resultSet = prepareStatement.executeQuery();

			// 4、从结果集ResultSet中取出数据并转换成实体类
			User u = null;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String userName = resultSet.getString("user_name");
				u = new User();
				u.setUserId(userId);
				u.setUserName(userName);
			}

			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5、按声明顺序倒序关闭
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
