import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class User {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		Class.forName("com.mysql.jdbc.Driver");
		BufferedInputStream bis= new BufferedInputStream(System.in);
        char y=' ';
        System.out.println("1.Create\n2.Insert\n3.Display");
        System.out.println("Enter Choice:");
        while(y!='`'){
        	y=(char)bis.read();
        	if(y=='1'){
        		create();
        		System.out.println("Creation Done!!");
        		}
        	if(y=='2'){
        		insert();
        		System.out.println("Insertion done");
        		}
        	else if(y=='3')
    		    display();
        		
        }
	
	}
		private static void create() throws IOException {
		// TODO Auto-generated method stub
			
			try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arj1","root","root");
			Statement sp= con.createStatement();
			BufferedInputStream bis= new BufferedInputStream(System.in);
	         String x1="";
	         char y=' ';
	         System.out.println("Enter Table Name:");
	         while(y!='\n'){
	        	 y=(char)bis.read();      	
	        	 x1+=y;
	         }
			String sql = "CREATE TABLE "+x1 +
	                "(id INTEGER not NULL, " +
	                " first VARCHAR(255))"; 

	        sp.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Table exists change table name");
			}
			//sp.executeUpdate("CREATE DATABASE STUDENTS ");
		
	}
		public static void insert() throws SQLException{
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/arj1","root","root");
		Statement sp= con.createStatement();
		String x="emp";
		String sql = "INSERT INTO "+x+
                " VALUES (100, 'Zara')";
		sp.executeUpdate(sql);
		}
		
		
		public static void display(){
		
			try{
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/arj1","root","root");
				Statement sp= con.createStatement();
				String x="emp";
				ResultSet rs= sp.executeQuery("Select * from student");
				while(rs.next()){
					System.out.println("Id:"+rs.getInt(1)+"\tName:"+rs.getString(2));		 
								}
				}catch(Exception e){
					e.printStackTrace();
				}
	}

}
