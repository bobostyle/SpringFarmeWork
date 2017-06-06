package org.smart4j.chapter1.helper;

import java.util.HashSet;
import java.util.Set;

import org.smart4j.chapter1.annotation.Controller;
import org.smart4j.chapter1.annotation.Service;
import org.smart4j.chapter1.util.ClassUtil;
/**
 * ClassHelper.java
 * 2017��6��7������12:02:23
 * @author cbb
 * TODO �����������
 */
public class ClassHelper {

	private static final Set<Class<?>> CLASS_SET;
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	/*
	 * ��ȡӦ�ð����µ�������
	 */
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	
	/*
	 * ��ȡ���������µ�����Service��
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
	 * ��ȡ���������µ�����Controller��
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
	 * ��ȡӦ���������е�Bean��
	 */
	
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
	
}
