package com.asiainfo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Cglib动态代理
 *
 * @author zhangzhiwang
 * @date Aug 27, 2019 7:50:17 PM
 */
public class CglibProxy implements MethodInterceptor {
	/** 被代理的对象 */
	private static Object target;

	public static Object getCglibInstance(Object o) {
		target = o;

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(new CglibProxy());
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("调用目标方法前做一些事情(cglib)");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("调用目标方法后做一些事情(cglib)");
		return result;
	}
}
