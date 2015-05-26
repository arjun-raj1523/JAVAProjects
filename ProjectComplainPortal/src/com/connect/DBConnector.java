package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static DBConnector dbConnector = new DBConnector( );
	Connection con;
	private DBConnector(){}
	
	public static DBConnector getInstance( ) {
	      return dbConnector;
	   }
	
	public Connection getConnection()  {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/complainportal","root","root");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;	
		
	}
}
