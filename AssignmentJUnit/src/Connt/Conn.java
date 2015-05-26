package Connt;
import java.io.IOException;
import java.sql.*;


public class Conn {

	
	public static void connect() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arj1","root","root");
	}

}
