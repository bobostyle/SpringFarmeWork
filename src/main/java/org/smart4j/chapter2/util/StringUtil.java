package org.smart4j.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringUtil.java
 * 2017年5月9日上午12:00:17
 * @author cbb
 * TODO 对String类的一些操作
 */ 
public class StringUtil {
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class.getName());
	
	public static void testLog(){
		logger.info("info test");
		logger.debug("debug test");
	}
}
