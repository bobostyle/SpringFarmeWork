package org.smart4j.chapter2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.dao.CustomerMapper;
import org.smart4j.chapter2.service.dao.SqlSessionBuilderManager;

/**
 * CustomerService.java
 * 2017年5月6日下午4:14:18
 * @author cbb
 * TODO 
 */  
public class CustomerServiceImpl implements CustomerService{
		
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl(){
	}
	public static CustomerServiceImpl getInstance(){
		return instance;
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customer = new ArrayList<Customer>();
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			customer = customerMapper.selectAllCustomer();
		}catch(Exception e){
			System.out.println(e.getMessage()); //查询数据库的时候，也有可能出现异常，比方说数据库链接异常。这时候会查询失败，但是不需要回滚操作
		}
		finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return customer;
	}

	@Override
	public Customer getCustomerByPrimKey(long id) {
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		Customer customer = null;
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			customer = customerMapper.selectCustomerById(id);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession); //一定要关闭sqlsession
		}
		return customer;
	}

	//如果是级联表还需要修改，插入父表和子表结构
	@Override
	public int addCustomer(Customer customer) {
		int result = 0;
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper= sqlSession.getMapper(CustomerMapper.class);
			result = customerMapper.insertCustomer(customer);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			//对于select查询操作不需要事务回滚，但是对于更新操作（update、insert、delete）如果异常的时候，需要事务回滚。
			SqlSessionBuilderManager.getInstance().rollBack(sqlSession);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return result;
	}
	
	@Override
	public int addMulitCustomers(List<Customer> customers) {
		int result = 0;
		if(customers == null || customers.size() == 0 ){
			return result;
		}
		for(int i = 0; i < customers.size(); i++){
			addCustomer(customers.get(i));
			result++;
		}
		return result;
	}
	
	//传入的是id和需要修改后的字段。id是前台传过来的,这时候选中某条记录就会记录相应的id
	@Override 
	public int updateCustomer(long id, Map<String, Object> filedMap) {
		int result = 0;
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			result = customerMapper.updateCustomer(filedMap);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			SqlSessionBuilderManager.getInstance().rollBack(sqlSession);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return result;
	}

	@Override
	public int deleteCustomer(long id) {
		int result = 0;
		SqlSession sqlSession = SqlSessionBuilderManager.getInstance().createSqlSession();
		try{
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			result = customerMapper.deleteCustomerById(id);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			SqlSessionBuilderManager.getInstance().rollBack(sqlSession);
		}finally{
			SqlSessionBuilderManager.getInstance().closeSqlSession(sqlSession);
		}
		return result;
	}
	
	@Override
	public int updateCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}
}
