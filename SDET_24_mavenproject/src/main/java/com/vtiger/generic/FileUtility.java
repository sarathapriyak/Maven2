package com.vtiger.generic;

import java.io.FileInputStream;


import java.util.Properties;

public class FileUtility {
	public String  getpropertyfile(String key) throws Throwable 
	{
		FileInputStream f=new FileInputStream("./data/vtiger.properties");
		Properties p=new Properties();
		p.load(f);
		String value = p.getProperty(key);
		return value;
		
	}

}
