package com.valueDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.connect.DBConnector;
import com.valueobjects.ComplainVO;
import com.valueobjects.CustomerVO;

public class ComplainDAO {
	
	Connection con;
	PreparedStatement pst1;
	CustomerVO cusVO;
	
	public ComplainDAO() {
		super();
		// TODO Auto-generated constructor stub
		con=DBConnector.getInstance().getConnection();
		
	}
	
	

	public int insertComplain(CustomerVO cusVO,ComplainVO comVO) {
		// TODO Auto-generated method stub
		try{
			pst1= con.prepareStatement("INSERT INTO `complainportal`.`complains`"
					+ "(`userId`,`name`,`complainText`)"
					+ "VALUES(?,?,?)");
			pst1.setString(1,cusVO.userId);
			pst1.setString(2,cusVO.name);
			pst1.setString(3,comVO.complainText);
			pst1.execute();
			
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
			
		}
	}	
	public int isReturnComplain(CustomerVO cusVO){
		
		con=DBConnector.getInstance().getConnection();
		try{
		pst1= con.prepareStatement("Select * from complains where userId=?");	
		pst1.setString(1,cusVO.userId);
		ResultSet rs=pst1.executeQuery();			
		rs.last();
			
		return rs.getInt(4);		
		}catch(Exception e){
			return 0;
		}
		
	}
	
public List isReturnCustomerComplainFromID(String complainID){
		con=DBConnector.getInstance().getConnection();
		List List1 = new ArrayList();
		try{
			pst1= con.prepareStatement("Select status from complains where complainID=?");		
			pst1.setString(1,complainID);
			ResultSet rs=pst1.executeQuery();
			while(rs.next())	
				List1.add(rs.getString(1));		
			return List1;
			
		}catch(Exception e){
			
			return null;
		}
	}

}
