package org.smart4j.chapter1.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

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
	
	//传入包名和类对象，就可以获取该包下，使用了传入注解的所有类
	//调用ClassUtil类的接口，获取指定包下的所有类
	//Class.isAnnotationPresent(Class))
	public static Set<Class<?>> getAllAnnotation(String packageName, Class<? extends Annotation> clazz){
		Set<Class<?>> allClass = ClassUtil.getClassSet(packageName); 
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for(Class<?> czz : allClass){
			if(czz.isAnnotationPresent(clazz)){
				classes.add(czz);
			}
		}
		return classes;
	}
	
	//获取指定包下，所有实现了某接口的类
	//调用ClassUtil类的接口，获取指定包下的所有类
	//public native boolean isAssignableFrom(Class<?> cls);
	public static Set<Class<?>> getAllImplClass(String packageName, Class<?> clazz){
		Set<Class<?>> clazzs = new HashSet<Class<?>>();
		Set<Class<?>> allClass = ClassUtil.getClassSet(packageName); 
		for(Class<?> clzz : allClass){
			if(clazz.isAssignableFrom(clzz)){
				clazzs.add(clzz);
			}
		}
		return clazzs;
	}
}	


