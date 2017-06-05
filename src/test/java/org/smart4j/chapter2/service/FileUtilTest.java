package org.smart4j.chapter2.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.smart4j.chapter2.util.FileUtil;

/**
 * FileUtilTest.java
 * 2017年5月20日下午7:33:05
 * @author cbb
 * TODO
 */
public class FileUtilTest {
	
	@Test
	public void when_specify_file_path_and_type_get_all_files() throws IOException{
		String fileType = ".sql";
		String resource = "script/";
		URL url = Resources.getResourceURL(resource);
		String filePath = url.getPath();
		System.out.println(filePath);
		List<File> files = FileUtil.getAllSpecifyTypeFiles(filePath, fileType);
		for(File file : files){
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
		}
	}
}
