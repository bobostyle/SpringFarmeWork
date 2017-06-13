package org.smart4j.chapter1.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * ReflectionUtil.java
 * 2017��6��7������12:18:18
 * @author cbb
 * TODO ���乤����
 */ 
public class ReflectionUtil {
	
	/*
	 * ����ʵ��
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
	 * ���÷���
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
	 * ���ó�Ա������ֵ
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


