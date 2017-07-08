package com.cg.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DBConnect {
	
	private static InitialContext context;
	private static DataSource dataSource;
	private static Connection con;
	
	static
	{
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/jdbc/TestDS");
			con = dataSource.getConnection();
			
		} 
		catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection()
	{
		return con;
	}
	

}
