package org.smart4j.chapter1.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.smart4j.chapter1.annotation.Action;
import org.smart4j.chapter1.annotation.Controller;
import org.smart4j.chapter1.bean.Handler;
import org.smart4j.chapter1.bean.Request;
/**
 * ControllerHelper.java
 * 2017年6月13日下午11:05:23
 * @author cbb 
 * TODO 获取指定包下使用Controller注解的所有类，遍历这些类，找出
 * 类中使用了Action注解的所有方法，然后获取注解的值，从值中获取到Request
 */
public class ControllerHelper {
	private static Map<Request, Handler> ActionMap = new HashMap<Request, Handler>();
	private static final String regex = "\\w+:/\\w*";
	static{
		initalActionAndHandlerMap();
	}
	/*
	 * 获取所有的Controller类
	 */
	private static void initalActionAndHandlerMap(){
		Set<Class<?>> allControllerClassSet = ClassHelper.getControllerClassSet(); //不存在空指针，最多是空数组
		for(Class<?> controllerClazz : allControllerClassSet){
			Method[] methods = controllerClazz.getDeclaredMethods();
			for(Method method : methods){
				if(method.isAnnotationPresent(Action.class)){
					Action action = method.getAnnotation(Action.class);
					String mapping = action.value(); //获取Action注解定义的值
					
					//验证URL的规则
					if(mapping.matches(regex)){
						String[] arrays = mapping.split(":");
						if(isValidated(arrays)){
							String requestMethod = arrays[0];
							String requestPath = arrays[1];
							Request request = new Request(requestMethod, requestPath);
							Handler handler = new Handler(Controller.class, method);
							ActionMap.put(request, handler);
						}
					}
				}
			}
			
			
		}
		
	}
	
	private static boolean isValidated(String[] arrays){
		if(arrays != null && arrays.length == 2){
			return true;
		}
		return false;
	}
	
	public static Handler getHandler(String requestMethod, String requestPath){
		Request request = new Request(requestMethod, requestPath);
		return ActionMap.get(request);
	}
}	
