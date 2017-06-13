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
 * 2017��6��13������11:05:23
 * @author cbb 
 * TODO ��ȡָ������ʹ��Controllerע��������࣬������Щ�࣬�ҳ�
 * ����ʹ����Actionע������з�����Ȼ���ȡע���ֵ����ֵ�л�ȡ��Request
 */
public class ControllerHelper {
	private static Map<Request, Handler> ActionMap = new HashMap<Request, Handler>();
	private static final String regex = "\\w+:/\\w*";
	static{
		initalActionAndHandlerMap();
	}
	/*
	 * ��ȡ���е�Controller��
	 */
	private static void initalActionAndHandlerMap(){
		Set<Class<?>> allControllerClassSet = ClassHelper.getControllerClassSet(); //�����ڿ�ָ�룬����ǿ�����
		for(Class<?> controllerClazz : allControllerClassSet){
			Method[] methods = controllerClazz.getDeclaredMethods();
			for(Method method : methods){
				if(method.isAnnotationPresent(Action.class)){
					Action action = method.getAnnotation(Action.class);
					String mapping = action.value(); //��ȡActionע�ⶨ���ֵ
					
					//��֤URL�Ĺ���
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
