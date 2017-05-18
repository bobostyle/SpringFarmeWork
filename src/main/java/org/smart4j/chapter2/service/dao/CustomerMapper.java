package org.smart4j.chapter2.service.dao;

import java.util.List;
import java.util.Map;
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
	
	int deleteCustomerById(long id);   //在jdbc中执行更新操作的sql一般返回都默认是int类型，如果不成功就是0，或者是受影响的行数
	int updateCustomer(Customer customer);
	int insertCustomer(Customer customer);
}
