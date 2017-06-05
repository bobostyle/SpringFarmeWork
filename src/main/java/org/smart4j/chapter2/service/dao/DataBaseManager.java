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
 * 2017��5��20������6:02:45
 * @author cbb
 * TODO ��ʼ�����ݿ�ͱ�ű�
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
	
	//����Ľӿ�
	public void initalSchemal(){
		if(!iSSatisfied()){
			executlSqlScript();
		}
	}
	
	//���һ���ж��Ǵ������ݿ��������������ÿ��������ʱ�򣬶���ʼ�����ݿ�ͱ�
	private boolean iSSatisfied(){
		return false;
	}
	
	//��ʼ�����ݿ�(��ֻ���ǵ�һ��ִ�У���ʵ����ִ�е�ʱ�򣬾Ͳ������´������ݿ�ͱ���)
	private void executlSqlScript(){
		List<File> scriptFiles = FileUtil.getAllSpecifyTypeFiles(FileUtil.getResourceFilePath(CommonConst.SRCIPTRE_SOURCE), CommonConst.SPECIFY_FILE_TYPE);
		Connection conn = getConnection();
		ScriptRunner runner = new ScriptRunner(conn); 
//		runner.setErrorLogWriter(null); 
//		runner.setLogWriter(null);   // �������Ǿ����Ƿ������־��ӡ��Ϣ
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
