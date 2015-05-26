package com.valueDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.TableView;

import com.connect.DBConnector;
import com.valueobjects.ComplainVO;
import com.valueobjects.CustomerVO;

public class CustomerDAO {
	Connection con;
	PreparedStatement pst1,pst2;
	CustomerVO cusVO;
    ComplainVO comVO= new ComplainVO();
    String name;
    
	public CustomerDAO() {
		super();
		// TODO Auto-generated constructor stub
		
		
	}
	
	public int isValidLogin(String userId,String pass){
		
		con=DBConnector.getInstance().getConnection();
		try{
		pst1= con.prepareStatement("Select * from login where UserId=?");
		pst1.setString(1,userId);
		ResultSet rs=pst1.executeQuery();
		rs.next();
		
		if(pass.equals(rs.getString(3)))
		{
			
			return 1;
		
		}
		else
		return 0;
		}catch(Exception e){
			return 2;
		}
	}
	
	public int register(String userId,String pass,String name,String address){
		try{
			pst1= con.prepareStatement("INSERT INTO `complainportal`.`login`"
										+ "(`UserId`,`Name`,`password`) "
										+ "VALUES (?,?,?);");
			pst2= con.prepareStatement("INSERT INTO `complainportal`.`customerdetails`"
					+ "(`userId`,`Name`,`address`) "
					+ "VALUES (?,?,?);");
			pst1.setString(1,userId);
			pst1.setString(2,name);
			pst1.setString(3,pass);
			
			pst2.setString(1,userId);
			pst2.setString(2,name);
			pst2.setString(3,address);
			
			pst1.execute();
			pst2.execute();
			return 1;
			
		}catch(Exception e){
			return 0;	
		}
		
	}
	
	
public String isReturnName(String userId){
		
		con=DBConnector.getInstance().getConnection();
		try{
		pst1= con.prepareStatement("Select * from customerdetails where userId=?");	
		pst1.setString(1,userId);
		ResultSet rs=pst1.executeQuery();
		rs.next();		
			return rs.getString(2);		
		}catch(Exception e){
			return null;
		}
		
	}	

public String isReturnAddress(String userId){
	
	con=DBConnector.getInstance().getConnection();
	try{
	pst1= con.prepareStatement("Select * from customerdetails where userId=?");	
	pst1.setString(1,userId);
	ResultSet rs=pst1.executeQuery();
	rs.next();		
		return rs.getString(3);		
	}catch(Exception e){
		return null;
	}
	
}

public Map isReturnCustomerCompalinDetails(CustomerVO cusVO){
	con=DBConnector.getInstance().getConnection();
	Map Map1 = new HashMap();
	try{
		pst1= con.prepareStatement("select distinct userId,name from complainportal.complains;");	
		
		ResultSet rs=pst1.executeQuery();
		while(rs.next())		
			Map1.put(rs.getString(1),rs.getString(2));
		return Map1;
		
	}catch(Exception e){
		
		return null;
	}
}

public List isReturnCustomerComplain(String complainText){
	con=DBConnector.getInstance().getConnection();
	ArrayList list1 = new ArrayList();
	try{
		pst1= con.prepareStatement("Select distinct name from complains where complainText=?");		
		pst1.setString(1,complainText);
		ResultSet rs=pst1.executeQuery();
		while(rs.next())		
			list1.add(rs.getString(1));
		
		return list1;
		
	}catch(Exception e){
		
		return null;
	}
}

public Map isReturnCustomerComplainFromName(String customerName){
	con=DBConnector.getInstance().getConnection();
	Map Map1 = new HashMap();
	try{
		pst1= con.prepareStatement("Select complainText,complainID from complains where name like ? or name like ? or name like ?");		
		pst1.setString(1,"%"+customerName);
		pst1.setString(2,"%"+customerName+"%");
		pst1.setString(3,customerName+"%");
		ResultSet rs=pst1.executeQuery();
		while(rs.next())	
			Map1.put(rs.getString(2),rs.getString(1));		
		return Map1;
		
	}catch(Exception e){
		
		return null;
	}
}

public List isReturnName(){
	ArrayList list1 = new ArrayList();
	con=DBConnector.getInstance().getConnection();
	try{
	pst1= con.prepareStatement("Select name from customerdetails");	
	ResultSet rs=pst1.executeQuery();
	while(rs.next())
		list1.add(rs.getString(1));
		return list1;
	}catch(Exception e){
		return null;
	}
	
}

}
