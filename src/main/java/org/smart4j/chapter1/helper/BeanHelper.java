package org.smart4j.chapter1.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.smart4j.chapter1.util.ClassUtil;
import org.smart4j.chapter1.util.ReflectionUtil;

/**
 * BeanHelper.java
 * 2017年6月12日下午10:29:45
 * @author cbb
 * TODO 组件所有的bean对象
 */
public class BeanHelper {

	private static Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();
	static{
		initalBeanMap();
	}
	
	private static void initalBeanMap(){
		Set<Class<?>> beanClazzSet = ClassUtil.getClassSet("");
		for(Class<?> clazz : beanClazzSet){
			Object instance = ReflectionUtil.newInstance(clazz);
			beanMap.put(clazz, instance);
		}
	}
	
	public static Map<Class<?>, Object> getBeanMap(){
		return beanMap;
	}
	
	/*
	 * 获取Bean的实例
	 */
	@SuppressWarnings("unchecked")
	public <T extends Object> T getBean(Class<?> clazz){
		return (T)beanMap.get(clazz);
	}
}
