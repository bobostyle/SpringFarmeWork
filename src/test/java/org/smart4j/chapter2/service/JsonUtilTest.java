package org.smart4j.chapter2.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.JsonUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


/**
 * JsonUtilTest.java
 * 2017年5月20日下午3:21:52
 * @author cbb
 * TODO
 */
public class JsonUtilTest {
	
	@Test
	public void test_JSON_String_2_Java_Bean() throws JsonParseException, JsonMappingException, IOException{
		Customer customer = new Customer();
		String jsonStr = "{\"name\":\"cbb\",\"contact\":\"zhang\",\"telephone\":99999}";
		customer = JsonUtil.stringtoObject(jsonStr, Customer.class);
		System.out.println(customer.toString());
	}
	
	@Test
	public void test_java_bean_2_json_string() throws JsonProcessingException{
		Customer customer1 = new Customer();
		customer1.setName("zhang");
		customer1.setContact("san");
		customer1.setEmail("@gamil");
		customer1.setRemark("good");
		
		Customer customer2 = new Customer();
		customer2.setName("wang");
		customer2.setContact("qiang");
		customer2.setEmail("@");
		customer2.setRemark("test");
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer1);
		customers.add(customer2);
		System.out.println(JsonUtil.javaBean2JsonString(customers));
	}
}
