package org.smart4j.chapter2.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonUtil.java
 * 2017��5��20������3:00:30
 * @author cbb
 * TODO  ʹ��JackSon ʵ��javabean��json����֮���ת��
 */ 
public class JsonUtil {
	
	//json�ַ���ת��javabean
	@SuppressWarnings("unchecked")
	public static <T> T stringtoObject(String jsonString, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper obejctMapper = new ObjectMapper();
		Object object = (Object)obejctMapper.readValue(jsonString, clazz);
		return (T)object;
	}
	
	//javabean�Ķ���ת��String����
	public static String javaBean2JsonString(Object obj) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStr = objectMapper.writeValueAsString(obj);
		return jsonStr;
	}
}