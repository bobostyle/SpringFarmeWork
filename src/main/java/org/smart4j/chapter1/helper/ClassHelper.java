package org.smart4j.chapter1.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.smart4j.chapter1.annotation.Controller;
import org.smart4j.chapter1.annotation.Service;
import org.smart4j.chapter1.util.ClassUtil;

/**
 * Class.java
 * 2017年6月12日下午10:14:09
 * @author cbb
 * TODO
 */
public class ClassHelper {
	
	private static Set<Class<?>> CLASS_SET = new HashSet<Class<?>>();
	private static final String BASE_PACKAGE = ConfigHelper.getAppBasePackage(); //这里面是不是有一个加载顺序的问题
	static{
		CLASS_SET = ClassUtil.getClassSet(BASE_PACKAGE);
	}
	
	public static Set<Class<?>> getAllClassSet(){
		return CLASS_SET;
	}
	
	private static Set<Class<?>> getSpecifyClassSet(Class<? extends Annotation> clazz){
		Set<Class<?>> classSets = new HashSet<Class<?>>();
	    for(Class<?> clz : CLASS_SET){
	    	if(clz.isAnnotationPresent(clazz)){
	    		classSets.add(clz);
	    	}
	    }
	    return classSets;
	}
	
	/*
	 * 获取包下所有的Service的对象
	 */
	public static Set<Class<?>> getServiceClassSet(){
		return getSpecifyClassSet(Service.class); 
	}
	
	/*
	 * 获取包下所有的Controller对象 
	 */
	public static Set<Class<?>> getControllerClassSet(){
		return getSpecifyClassSet(Controller.class);
	}
	
}
