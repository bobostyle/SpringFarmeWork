package org.smart4j.chapter2.service.dao;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

/**
 * SessionContext.java
 * 2017年5月15日下午10:41:16
 * @author cbb 
 * TODO 存储每一个操作，线程所创建的session
 */
public class SqlSessionContext {
	
	private static SqlSessionContext instance = new SqlSessionContext();
	private SqlSessionContext(){
	}
	public static SqlSessionContext getInstance(){
		return instance;
	}
	private Map<Long, SqlSession> sqlSessionsMap = new HashMap<Long, SqlSession>();
	
	public SqlSession getSqlSession(String id){
		return sqlSessionsMap.get(id);
	}
	
	public void createSqlSession(SqlSession sqlSession){
		if(sqlSession == null){
			sqlSessionsMap.put(Thread.currentThread().getId(), SqlSessionBuilderManager.getInstance().createSqlSession());
		}
		
	}
	
	public void removeSqlSession(SqlSession sqlSession){
		sqlSessionsMap.remove(sqlSession);
	}
	
	public static void main(String[] args) {
		
	}
	
}
