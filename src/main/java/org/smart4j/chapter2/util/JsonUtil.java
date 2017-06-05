package org.smart4j.chapter2.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonUtil.java
 * 2017年5月20日下午3:00:30
 * @author cbb
 * TODO  使用JackSon 实现javabean和json对象之间的转换
 */ 
public class JsonUtil {
	
	//json字符串转成javabean
	@SuppressWarnings("unchecked")
	public static <T> T stringtoObject(String jsonString, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper obejctMapper = new ObjectMapper();
		Object object = (Object)obejctMapper.readValue(jsonString, clazz);
		return (T)object;
	}
	
	//javabean的对象转成String类型
	public static String javaBean2JsonString(Object obj) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr = objectMapper.writeValueAsString(obj);
		return jsonStr;
	}
}