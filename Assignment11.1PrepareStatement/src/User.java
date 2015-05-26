import java.sql.*;

public class User {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/arj1","root","root");	
	   //Insert
		PreparedStatement pst1= con.prepareStatement("INSERT INTO emp VALUES (?, ?)");
		pst1.setInt(1,1);
		pst1.setString(2,"Karan");
		pst1.execute();
		pst1.setInt(1,2);
		pst1.setString(2,"arjun");
		pst1.execute();
		pst1.setInt(1,3);
		pst1.setString(2,"zara");
		pst1.execute();
		pst1.setInt(1,4);
		pst1.setString(2,"bara");
		pst1.execute();
	
		System.out.println("Before Update\n");
		//display
				PreparedStatement pst3= con.prepareStatement("Select * from emp");
				ResultSet rs= pst3.executeQuery();
				while(rs.next()){
					System.out.println("Id:"+rs.getInt(1)+"\tName:"+rs.getString(2));		 
								}

		//Update
		PreparedStatement pst2= con.prepareStatement("UPDATE emp SET "
				+ "Name=? "
				+ "WHERE Id=1;");
		pst2.setString(1,"Roy");
		pst2.execute();
		System.out.println("After Update\n");
		ResultSet rs1= pst3.executeQuery();
		while(rs1.next()){
			System.out.println("Id:"+rs1.getInt(1)+"\tName:"+rs1.getString(2));		 
						}	
		
		System.out.println("Into table student");
		
		//Insert
				PreparedStatement pst4= con.prepareStatement("INSERT INTO student VALUES (?, ?)");
				pst4.setInt(1,1);
				pst4.setString(2,"Karan");
				pst4.execute();
				pst4.setInt(1,2);
				pst4.setString(2,"arjun");
				pst4.execute();
				pst4.setInt(1,3);
				pst4.setString(2,"zara");
				pst4.execute();
				pst4.setInt(1,4);
				pst4.setString(2,"bara");
				pst4.execute();
				//display
						PreparedStatement pst5= con.prepareStatement("Select * from student");
						ResultSet rs5= pst5.executeQuery();
						while(rs5.next()){
							System.out.println("Id:"+rs5.getInt(1)+"\tName:"+rs5.getString(2));		 
										}
	
}
	

}
