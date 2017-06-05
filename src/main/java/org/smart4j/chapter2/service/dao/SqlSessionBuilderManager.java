package org.smart4j.chapter2.service.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SqlSessionManager.java
 * 2017年5月10日下午11:19:39
 * @author cbb
 * TODO 根据mybatis的配置文件，管理和创建sqlSession的
 */
public class SqlSessionBuilderManager {
	private static final Logger logger = LoggerFactory.getLogger(SqlSessionBuilderManager.class);
	private static SqlSessionBuilderManager instance = new SqlSessionBuilderManager();
	private SqlSessionFactory sqlSessionFactory = null;
	private SqlSessionBuilderManager(){
		createSqlSessionFactory();
	}
	public static SqlSessionBuilderManager getInstance(){
		return instance;
	}
	
	//SqlSessionFactory 加载了xml的工厂类，只需要执行一次就行。
	private void createSqlSessionFactory(){
		String resource = "mybatis-conf.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e){
			
			
			System.out.println(e.getMessage());
		}
	}
	
	//SqlSession最好是方法作用域，千万不要使用静态域或者类作用域
	public SqlSession createSqlSession(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	public void closeSqlSession(SqlSession session){
		if(session != null){
			session.close();
		}
	}
	
	/*
	 * 事务操作，如果出现异常，那么就会回滚
	 */
	public void rollBack(SqlSession session){
		if(session != null){
			session.rollback();
		}
	}
	
	public void commit(SqlSession session){
		if(session != null){
			session.commit();
		}
	}
	
}
