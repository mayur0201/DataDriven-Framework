package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static void main (String args[]) throws IOException
	{
		Properties config = new Properties();
		Properties OR = new Properties();
		
		System.out.println(System.getProperty("user.dir"));
		
		FileInputStream fisConfig = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		FileInputStream fisOR = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		
		config.load(fisConfig);
		OR.load(fisOR);
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlBtn"));
		
		
	}
	

}

