package org.smart4j.chapter1.util;

 /**
 * StringUtil.java
 * 2017年6月5日下午11:46:11
 * @author cbb
 * TODO
 */
public class StringUtil {
	
	public static boolean isNotEmpty(String str){
		if(null != str && !str.isEmpty()){
			return true;
		}
		return false;
	}
}	
