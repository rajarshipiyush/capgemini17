package com.cg.patientdetails.dbutil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	
	static Properties prop = new Properties();
	static String driver;
	static String user;
	static String pass;
	static String url;
	static Connection con;
	
	static
	{
		
		try
		{
			prop.load(new FileInputStream("jdbc.properties"));
			driver = prop.getProperty("driver");
			//driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pass = prop.getProperty("pass");
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pass);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		return con;
	}

}
