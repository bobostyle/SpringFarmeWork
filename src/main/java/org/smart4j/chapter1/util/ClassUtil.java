package org.smart4j.chapter1.util;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * ClassUtil.java
 * 2017年6月5日下午10:50:53
 * @author cbb
 * TODO 类加载器来加载该基础包名下的所有类
 * 1、使用了某注解的类  (@Bean)
 * 2、实现了某接口的类  (implements) 在项目框架中，提供了一个监听接口，就可以实现注册监听。
 * 3、继承了某父类的所有子类 (extends Pather)
 */
public class ClassUtil {
	
	/*
	 * 获取指定包名下的所有类
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
	
	private static ClassLoader getClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}
	
	private static Class<?> loadClass(String className, boolean isInitiallized) {
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
	
	//传入包名和类对象，就可以获取该包下，使用了传入注解的所有类
	//调用ClassUtil类的接口，获取指定包下的所有类
	//Class.isAnnotationPresent(Class))
	public static Set<Class<?>> getAllSpecifyAnnotation(String packageName, Class<? extends Annotation> clazz){
		Set<Class<?>> allClass = getClassSet(packageName); 
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for(Class<?> czz : allClass){
			if(czz.isAnnotationPresent(clazz)){
				classes.add(czz);
			}
		}
		return classes;
	}

	// 获取指定包下，所有实现了某接口的类
	// 调用ClassUtil类的接口，获取指定包下的所有类
	// public native boolean isAssignableFrom(Class<?> cls);
	public static Set<Class<?>> getAllSpecifyImplClass(String packageName, Class<?> clazz) {
		Set<Class<?>> clazzs = new HashSet<Class<?>>();
		Set<Class<?>> allClass = getClassSet(packageName);
		for (Class<?> clzz : allClass) {
			if (clazz.isAssignableFrom(clzz)) {
				clazzs.add(clzz);
			}
		}
		return clazzs;
	}
}
 