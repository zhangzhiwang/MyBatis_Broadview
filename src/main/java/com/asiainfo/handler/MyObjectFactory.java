package com.asiainfo.handler;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * 自定义对象工厂——将数据库查询出来的数据转换成POJO
 *
 * @author zhangzhiwang
 * @date Aug 25, 2019 11:28:28 AM
 */
public class MyObjectFactory extends DefaultObjectFactory {
	private static final long serialVersionUID = -7934923633083796221L;

//	@Override
//	public void setProperties(Properties properties) {
//		
//	}

	@Override
	public <T> T create(Class<T> type) {
		System.out.println("使用自定义的MyObjectFactory构建单个对象");
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		System.out.println("使用自定义的MyObjectFactory对象列表");
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public <T> boolean isCollection(Class<T> type) {
		System.out.println("使用自定义的MyObjectFactory判断是否为集合");
		return super.isCollection(type);
	}

}
