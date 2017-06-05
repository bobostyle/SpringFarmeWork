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
 * 2017��5��10������11:19:39
 * @author cbb
 * TODO ����mybatis�������ļ�������ʹ���sqlSession��
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
	
	//SqlSessionFactory ������xml�Ĺ����ֻ࣬��Ҫִ��һ�ξ��С�
	private void createSqlSessionFactory(){
		String resource = "mybatis-conf.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e){
			
			
			System.out.println(e.getMessage());
		}
	}
	
	//SqlSession����Ƿ���������ǧ��Ҫʹ�þ�̬�������������
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
	 * �����������������쳣����ô�ͻ�ع�
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
