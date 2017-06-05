package org.smart4j.chapter2.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;

/**
 * FileUtil.java
 * 2017年5月9日上午12:00:37
 * @author cbb
 * TODO 对文件的一些操作
 */
public class FileUtil {

	//递归获取指定路径下的所有指定类型文件
	public static List<File> getAllSpecifyTypeFiles(String filePath, String fileType){
		List<File> files = new ArrayList<File>();
		if(filePath == null || fileType == null){
			return files; //返回空文件，避免空指针
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
