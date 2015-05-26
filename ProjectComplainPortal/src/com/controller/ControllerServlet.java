package com.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.valueDAO.ComplainDAO;
import com.valueDAO.CustomerDAO;
import com.valueobjects.ComplainVO;
import com.valueobjects.CustomerVO;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String action,userId,pass,name,complainText,address,customerName,complainID;
    int objcomplain;
    int check;
    int temp;
    CustomerDAO customer = new CustomerDAO();
    ComplainDAO complain = new ComplainDAO();
    CustomerVO cusVO= new CustomerVO();
    ComplainVO comVO= new ComplainVO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init(){
    	
    	
    	
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    	
    		ServletContext sc= this.getServletContext();
    		RequestDispatcher rd = sc.getRequestDispatcher("/Login.jsp");	
    		HttpSession session = request.getSession();
    		session.invalidate();
    		request.setAttribute("label","logout");
    		rd.forward(request, response);
    		
    		
    	
    	
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		action =request.getParameter("action");
		userId =request.getParameter("userId");
		pass =request.getParameter("pass");
		name=request.getParameter("name");
		complainID=request.getParameter("complainID");
		address=request.getParameter("address");		
		customerName= request.getParameter("customerName");
		complainText=request.getParameter("complainDropDown");
		comVO.setComplainText(complainText);
		java.util.List returnList= new  ArrayList();
		java.util.List returnListName= new  ArrayList();
		HashMap returnmap= new HashMap(); 
		PrintWriter out= response.getWriter();
		ServletContext sc= this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/Login.jsp");
		RequestDispatcher rd1 = sc.getRequestDispatcher("/ComplainPortal.jsp");
		
		switch(action){
			/*login
			 * 
			 * 
			 */
		case "login":
				
				   check=customer.isValidLogin(userId, pass);
				 
					if(check==1)
						{
						// Valid User Name
						   	cusVO.setUserId(userId);						   	
						    String objName=customer.isReturnName(userId);
						   	cusVO.setName(objName);
						   	String objAddress=customer.isReturnAddress(userId);
						   	cusVO.setAddress(objAddress);
						   	returnListName=customer.isReturnName();
						   	request.setAttribute("nameListSearch",returnListName);
						   	session.setAttribute("username",customerName);
							rd1.forward(request, response);
						}
					else if(check==2){
							
							request.setAttribute("label","InvalidUser");//Wrong User Name
							rd.include(request, response);
							
							
						}
					else{
						
							rd.include(request, response);//Wrong Password
							
						}
					break;
		/* new user
		 * 
		 * 
		 */
		case "newUser":
					check=customer.register(userId, pass, name,address);
					
					if(check==1){				//successful registration
						cusVO.setUserId(userId);						   	
					    String objName=customer.isReturnName(userId);
					   	cusVO.setName(objName);
					   	String objAddress=customer.isReturnAddress(userId);
					   	cusVO.setAddress(objAddress);
					   	returnListName=customer.isReturnName();
						returnListName=customer.isReturnName();
					   	request.setAttribute("nameListSearch",returnListName);
						rd1.forward(request, response);
					}
					else{						
						//unsuccesfull registration
						request.setAttribute("label","sameUser");
						rd.forward(request, response);
						}
					break;
					
		case "launchComplain":
						
						check=complain.insertComplain(cusVO,comVO);
						if(check==1){
							//launch successfull
							int objcomplain=complain.isReturnComplain(cusVO);
							comVO.setComplainNum(objcomplain);
							request.setAttribute("label","success");
							returnListName=customer.isReturnName();
						   	request.setAttribute("nameListSearch",returnListName);
							rd1.include(request, response);
						
						
						}
						else
						{
							//launch unsuccessfull
							returnListName=customer.isReturnName();
						   	request.setAttribute("nameListSearch",returnListName);
							rd1.include(request, response);
							
						}
						break;
						/*check status
						 * 
						 * 
						 */
		case "complainstatus":
						returnList= complain.isReturnCustomerComplainFromID(complainID);
						request.setAttribute("complainStatus",returnList);
						returnListName=customer.isReturnName();
					   	request.setAttribute("nameListSearch",returnListName);
						rd1.include(request, response);			 			
						break;
						/*search customer on complains
						 * 
						 * 
						 */
		case "searchCustomer":
			 			returnList =  customer.isReturnCustomerComplain(complainText);
			 			request.setAttribute("nameList", returnList);	
			 			returnListName=customer.isReturnName();
					   	request.setAttribute("nameListSearch",returnListName);
			 			rd1.include(request, response);
			 			
						break;
						/*search customer by name
						 * 
						 * 
						 */
		case "customerNameSearch":
						
						returnmap=(HashMap) customer.isReturnCustomerComplainFromName(customerName);
						request.setAttribute("complainmap", returnmap);
						returnListName=customer.isReturnName();
					   	request.setAttribute("nameListSearch",returnListName);
						rd1.include(request, response);
						
						break;
		
		}
		
		
		
	}

}
