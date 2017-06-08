package org.smart4j.chapter1.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

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
	
	//�������������󣬾Ϳ��Ի�ȡ�ð��£�ʹ���˴���ע���������
	//����ClassUtil��Ľӿڣ���ȡָ�����µ�������
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
	
	//��ȡָ�����£�����ʵ����ĳ�ӿڵ���
	//����ClassUtil��Ľӿڣ���ȡָ�����µ�������
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


