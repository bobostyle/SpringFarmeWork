package org.smart4j.chapter1.helper;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import org.smart4j.chapter1.annotation.Inject;
import org.smart4j.chapter1.util.ReflectionUtil;

/**
 * IocHelper.java
 * 2017年6月12日下午10:47:45
 * @author cbb
 * TODO 依赖注入助手类
 */
public class IocHelper {
	
	static{
		initalIoc();
	}
	
	private static void initalIoc(){
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		for(Entry<Class<?>, Object> entrySets : beanMap.entrySet()){
			Class<?> clazz = entrySets.getKey();
			Object instance = entrySets.getValue();
			//获取bean对象所定义的所有属性
			Field[] fields = clazz.getFields();
			for(Field field : fields){
				if(field.isAnnotationPresent(Inject.class)){
					Class<?> beanFieldClass = field.getType();
					Object beanFiledInstance = beanMap.get(beanFieldClass);
					if(beanFiledInstance != null){
						ReflectionUtil.setFiled(instance, field, beanFiledInstance);
					}
				}
			}
		}
	}
}