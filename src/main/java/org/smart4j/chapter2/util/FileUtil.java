package org.smart4j.chapter2.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;

/**
 * FileUtil.java
 * 2017��5��9������12:00:37
 * @author cbb
 * TODO ���ļ���һЩ����
 */
public class FileUtil {

	//�ݹ��ȡָ��·���µ�����ָ�������ļ�
	public static List<File> getAllSpecifyTypeFiles(String filePath, String fileType){
		List<File> files = new ArrayList<File>();
		if(filePath == null || fileType == null){
			return files; //���ؿ��ļ��������ָ��
		}
		File tempFile = new File(filePath);
		for(File file : tempFile.listFiles()){
			if(file.isDirectory()){
				files.addAll(getAllSpecifyTypeFiles(file.getPath(), fileType));
			}else{
				if (file.getName().endsWith(fileType)) {
					files.add(file);
				}	
			}
		}
		return files;
	}
	
	public static String getResourceFilePath(String resource) {
		String filePath = "";
		try{
			URL url = Resources.getResourceURL(resource);
			filePath = url.getPath();
		}catch(IOException ex){
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		}
		return filePath;
	}
}
