package org.smart4j.chapter1.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * ReflectionUtil.java
 * 2017年6月7日上午12:18:18
 * @author cbb
 * TODO 反射工具类
 */ 
public class ReflectionUtil {
	
	/*
	 * 创建实例
	 */
	public static Object newInstance(Class<?> clazz){
		Object instance = null;
		try {
			instance = Class.forName(clazz.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return instance;
	}
	
	/*
	 * 调用方法
	 */
	public static Object invokeMethod(Object obj, Method method, Object... args){
		Object object = null;
		try{
			method.setAccessible(true);
			object = method.invoke(obj, args);
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return object;
	}
	
	/*
	 * 设置成员变量的值
	 */
	public static void setFiled(Object obj, Field field, Object value){
		try{
			field.setAccessible(true);
			field.set(obj, value);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}	


