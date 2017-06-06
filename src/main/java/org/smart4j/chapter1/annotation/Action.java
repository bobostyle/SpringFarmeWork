package org.smart4j.chapter1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Action.java
 * 2017��6��6������11:54:44
 * @author cbb
 * TODO �Զ���Actionע�⣬ʹ���ڷ�����
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	//����������·��
	String value();
}
