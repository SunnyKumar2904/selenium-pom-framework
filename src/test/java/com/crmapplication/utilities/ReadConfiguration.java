package com.crmapplication.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration 
{
	String path = System.getProperty("user.dir") + "/configuration/config.properties";
	Properties pro;
	
	public ReadConfiguration() 
	{	
		FileInputStream fn = null;
		
		try {
			fn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pro = new Properties();
		try {
			pro.load(fn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getUrl() {
		String u = pro.getProperty("url");
		
		if (u!=null) {
			return u;
		}else {
			throw new RuntimeException("Url not Found");
		}
	}
	

	
	public String getBrowser() {
		String bro = pro.getProperty("browser");
		
		if (bro!=null) {
			return bro;
		}else {
			throw new RuntimeException("browser not Found");
		}
	}
}
