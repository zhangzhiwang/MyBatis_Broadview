package com.asiainfo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.asiainfo.service.IUserService;
import com.asiainfo.service.UserServiceImpl;

/**
 * 	动态代理单元测试
 *
 * @author zhangzhiwang
 * @date Aug 27, 2019 7:40:29 PM
 */
public class DynamicProxyTest {

	@Test
	public void test() {
		IUserService proxyObject = (IUserService) JDBCDynamicProxy.getProxyObject(new UserServiceImpl());
		proxyObject.queryUserById(1);
	}
	
	@Test
	public void test2() {
		UserServiceImpl proxy = (UserServiceImpl) CglibProxy.getCglibInstance(new UserServiceImpl());
		proxy.queryUserById(1);
	}
}
