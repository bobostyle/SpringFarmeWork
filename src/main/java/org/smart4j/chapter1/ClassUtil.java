package org.smart4j.chapter1;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * ClassUtil.java
 * 2017��6��5������10:50:53
 * @author cbb
 * TODO ������������ظû��������µ�������
 * 1��ʹ����ĳע�����  (@Bean)
 * 2��ʵ����ĳ�ӿڵ���  (implements) ����Ŀ����У��ṩ��һ�������ӿڣ��Ϳ���ʵ��ע�������
 * 3���̳���ĳ������������� (extends Pather)
 */
public class ClassUtil {
	
	/*
	 * ��ȡ�������
	 */
	public static ClassLoader getClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}
	
	/*
	 * ������ ,�쳣�����˻��ǿ��Լ����ӳ�����
	 */
	public static Class<?> loadClass(String className, boolean isInitiallized) {
		Class<?> clazz = null;
		try{
			clazz = Class.forName(className, isInitiallized, getClassLoader());
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
		return clazz;
	}
	
	/*
	 * ��ȡָ�������µ�������
	 */
	public static Set<Class<?>> getClassSet(String packageName){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		try{
			Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
			while(urls.hasMoreElements()){
				URL url = urls.nextElement();
				if(url != null){
					String protocol = url.getProtocol();
					if(protocol.equals("file")){
						String packagePath = url.getPath().replaceAll("%20", "");
						addClass(classSet, packagePath, packageName);
					}else if(protocol.equals("jar")){
						JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
						if(jarURLConnection != null){
							JarFile jarFile = jarURLConnection.getJarFile();
							if(jarFile != null){
								Enumeration<JarEntry> jarEntries = jarFile.entries();
								while(jarEntries.hasMoreElements()){
									JarEntry jarEntry = jarEntries.nextElement();
									String jarEntryName = jarEntry.getName();
									if(jarEntryName.endsWith(".class")){
										String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
										doAddClass(classSet, className);
									}
								}
							}
						}
					}
				}
			}
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		return classSet;
	}
	
	private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName){
		File[] files = new File(packagePath).listFiles(new FileFilter(){
			@Override
			public boolean accept(File file) {
				return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
			}
		});
		
		for(File file : files){
			String fileName = file.getName();
			if(file.isFile()){
				String className = fileName.substring(0, fileName.lastIndexOf("."));
				if(StringUtil.isNotEmpty(packageName)){
					className = packageName + "." + className;
				}
				doAddClass(classSet, className);
			}else{
				String subPackagePath = fileName;
				if(StringUtil.isNotEmpty(packagePath)){
					subPackagePath = packagePath + "/" + subPackagePath;
				}
				String subPackageName = fileName;
				if(StringUtil.isNotEmpty(packageName)){
					subPackagePath = packageName + "." + subPackageName;
				}
				addClass(classSet, subPackagePath, subPackageName);
			}
		}
	}
	
	private static void doAddClass(Set<Class<?>> classSet, String className){
		Class<?> clazz = loadClass(className, false);
		classSet.add(clazz);
	}
}
 