package com.asiainfo.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.asiainfo.enums.LockEnum;

/**
 * 自定义转换器
 *
 * @author zhangzhiwang
 * @date Aug 25, 2019 9:41:15 AM
 */
public class MyEnumTypeHandler implements TypeHandler<LockEnum>{

	public void setParameter(PreparedStatement ps, int i, LockEnum lockEnum, JdbcType jdbcType) throws SQLException {
		System.out.println("使用MyEnumTypeHandler");
		ps.setInt(i, lockEnum.getCode());
	}

	public LockEnum getResult(ResultSet rs, String columnName) throws SQLException {
		System.out.println("使用MyEnumTypeHandler");
		int code = rs.getInt(columnName);
		return LockEnum.getByCode(code);
	}

	public LockEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		System.out.println("使用MyEnumTypeHandler");
		int code = rs.getInt(columnIndex);
		return LockEnum.getByCode(code);
	}

	public LockEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
		throw new RuntimeException("未使用");
	}
}
