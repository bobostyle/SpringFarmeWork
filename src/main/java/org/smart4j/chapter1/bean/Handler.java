package org.smart4j.chapter1.bean;

import java.lang.reflect.Method;

/**
 * Handler.java
 * 2017年6月13日下午11:01:26
 * @author cbb
 * TODO
 */
public class Handler {
	
	private Class<?> controllerClass;
  	private Method actionMethod;

  	public Handler(Class<?> controllerClass, Method actionMethod) {
  		this.controllerClass = controllerClass;
  		this.actionMethod = actionMethod;
  	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}
}
