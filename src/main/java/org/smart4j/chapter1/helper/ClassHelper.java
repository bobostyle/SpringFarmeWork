package org.smart4j.chapter1.helper;

import java.util.HashSet;
import java.util.Set;

import org.smart4j.chapter1.annotation.Controller;
import org.smart4j.chapter1.annotation.Service;
import org.smart4j.chapter1.util.ClassUtil;
/**
 * ClassHelper.java
 * 2017年6月7日上午12:02:23
 * @author cbb
 * TODO 类操作助手类
 */
public class ClassHelper {

	private static final Set<Class<?>> CLASS_SET;
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	/*
	 * 获取应用包名下的所有类
	 */
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	
	/*
	 * 获取基础包名下的所有Service类
	 */
	public static Set<Class<?>> getServiceClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> clazz : CLASS_SET){
			if(clazz.isAnnotationPresent(Service.class)){
				classSet.add(clazz);
			}
		}
		return classSet;
	}
	
	/*
	 * 获取基础包名下的所有Controller类
	 */
	public static Set<Class<?>> getControllerClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> clazz : CLASS_SET){
			if(clazz.isAnnotationPresent(Controller.class)){
				classSet.add(clazz);
			}
		}
		return classSet;
	}
	
	/*
	 * 获取应用名下所有的Bean类
	 */
	
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
	
}
