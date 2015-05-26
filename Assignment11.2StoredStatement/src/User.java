import java.sql.*;


public class User {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		   //Connect
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");	
			CallableStatement stmt = null;
			Statement s= con.createStatement();
			//Insert
			//s.executeUpdate("Insert into employees values(1,'Nikita',100,null)");
			//create Procedure
		    String SQL = "CREATE DEFINER=`root`@`localhost` PROCEDURE "
		    		+ "`HRA`() BEGIN "
		    		+ "UPDATE emp.employees "
		    		+ "SET HRA=(basicSalary*0.10)+BasicSalary;"
		    		+ "SELECt * from emp.employees;"
		    		+ "END;";
		    String drop="DROP PROCEDURE IF EXISTS `EMP`.`HRA`;";
		    s.execute(drop);
		    s.execute(SQL);
		    String sql1 = "{call HRA}";
		    stmt = con.prepareCall (sql1);
		    ResultSet rs= stmt.executeQuery();
		    
		     
		      //Retrieve employee name with getXXX method
		      
		     // String empName = stmt.getString(2);
		while(rs.next()){
					System.out.println("Id:"+rs.getInt(1)+"\tName:"+rs.getString(2)
							+"\tBasic Salary:"+rs.getFloat(3)+"\tHRA:"+rs.getFloat(4));		 
				}
		     
	}

}
