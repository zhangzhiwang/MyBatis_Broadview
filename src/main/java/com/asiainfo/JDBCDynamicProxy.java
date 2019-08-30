package com.asiainfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDBC动态代理
 *
 * @author zhangzhiwang
 * @date Aug 27, 2019 7:25:23 PM
 */
public class JDBCDynamicProxy implements InvocationHandler {
	/**被代理的对象*/
	private static Object target;
	
	

//	public JDBCDynamicProxy(Object target) {
//		super();
//		this.target = target;
//	}

	
	public static Object getProxyObject(Object t) {
		target = t;
		return Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new JDBCDynamicProxy());
	}


	/**
	 * proxy为代理对象。注意是代理对象，而不是被代理对象，被代理对象是类属性target
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用目标方法前做一些事情");
		Object result = method.invoke(target, args);
		System.out.println("调用目标方法后做一些事情");
		return result;
	}
	
}
