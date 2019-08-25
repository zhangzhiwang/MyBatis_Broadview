package com.asiainfo.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

/**
 * 自定义转换器
 *
 * @author zhangzhiwang
 * @date Aug 25, 2019 9:41:15 AM
 */
@MappedTypes({String.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyStringTypeHandler implements TypeHandler<String>{

	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		System.out.println("使用自定义的setParameter()");
		ps.setString(i, parameter);
	}

	public String getResult(ResultSet rs, String columnName) throws SQLException {
		System.out.println("使用自定义的getResult()，通过列名获取值");
		return rs.getString(columnName);
	}

	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		System.out.println("使用自定义的getResult()，通过列索引获取值");
		return rs.getString(columnIndex);
	}

	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		System.out.println("使用自定义的getResult()，通过存储过程索引获取值");
		return cs.getString(columnIndex);
	}

}
