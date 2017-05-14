package org.smart4j.chapter2.service.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.smart4j.chapter2.model.Customer;

/**
 * CustomerMapper.java
 * 2017��5��9������11:07:14
 * @author cbb Mapper Instance ӳ����ʵ��
 * TODO mybatis
 */
public interface CustomerMapper {
	List<Customer> selectAllCustomer();
	@Select("select * from customer where id = #{id}")
	Customer selectCustomerByIdAnnotation(long id);
	Customer selectCustomerById(long id);
	boolean deleteCustomerById(long id); 
	boolean updateCustomer(Customer customer);
	boolean insertCustomer(Customer customer);
}
