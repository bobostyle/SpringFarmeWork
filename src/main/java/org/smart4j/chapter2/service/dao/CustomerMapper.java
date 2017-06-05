package org.smart4j.chapter2.service.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.smart4j.chapter2.model.Customer;

/**
 * CustomerMapper.java
 * 2017年5月9日下午11:07:14
 * @author cbb Mapper Instance 映射器实例
 * TODO mybatis
 */
public interface CustomerMapper {
	
	List<Customer> selectAllCustomer();
	List<Customer> selectCustomerBySomeCondition(Customer customer);
	@Select("select * from customer where id = #{id}")
	Customer selectCustomerByIdAnnotation(long id);
	Customer selectCustomerById(long id);
	List<Customer> selectCustomers(List<Long> ids);
	
	int deleteCustomerById(long id);   
	
	int updateCustomer(Customer customer);
	
	int insertCustomer(Customer customer);
}
