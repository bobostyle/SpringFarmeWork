package org.smart4j.chapter2.service.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.smart4j.chapter2.CommonConst;
import org.smart4j.chapter2.util.FileUtil;
import com.mysql.jdbc.Connection;

/**
 * DataBaseManager.java
 * 2017年5月20日下午6:02:45
 * @author cbb
 * TODO 初始化数据库和表脚本
 */
public class DataBaseManager {
	
	private static String url = null;
	private static String driver = null;
	private static String username = null;
	private static String password = null;
	private static DataBaseManager instance = new DataBaseManager();
	private DataBaseManager(){
		initalDataBaseInfo();
	}
	
	private void initalDataBaseInfo(){
		Properties properties;
		try {
			properties = Resources.getResourceAsProperties("properties/jdbc.properties");
			url = properties.getProperty("url");
			driver = properties.getProperty("driver");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			//TODO
		}
	}
	
	public static DataBaseManager getInstance(){
		return instance;
	}
	
	private Connection getConnection(){
		try {
			Class.forName(driver).newInstance();
			Connection conn = (Connection) DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO 
		}
		return null;
	}
	
	//对外的接口
	public void initalSchemal(){
		if(!iSSatisfied()){
			executlSqlScript();
		}
	}
	
	//添加一个判断是存在数据库或者其他，避免每次启动的时候，都初始化数据库和表
	private boolean iSSatisfied(){
		return false;
	}
	
	//初始化数据库(先只考虑第一次执行，其实后面执行的时候，就不用重新创建数据库和表了)
	private void executlSqlScript(){
		List<File> scriptFiles = FileUtil.getAllSpecifyTypeFiles(FileUtil.getResourceFilePath(CommonConst.SRCIPTRE_SOURCE), CommonConst.SPECIFY_FILE_TYPE);
		Connection conn = getConnection();
		ScriptRunner runner = new ScriptRunner(conn); 
//		runner.setErrorLogWriter(null); 
//		runner.setLogWriter(null);   // 这两句是决定是否添加日志打印信息
		for(File scriptFile : scriptFiles){
			try{
				System.out.println(scriptFile.getName());
				runner.runScript(new InputStreamReader(new FileInputStream(scriptFile)));
			}catch(FileNotFoundException e){
				//TODO
			}
		}
		closeConnection(conn);
	}
	
	private void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				//TODO
			}
		}
	}
}
