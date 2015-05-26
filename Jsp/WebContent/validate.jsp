<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="javax.servlet.*"
   import="java.sql.*"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  String userName= request.getParameter("userName");
	String password=request.getParameter("password");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookreviewsystem","root","root");	
	PreparedStatement pst3= con.prepareStatement("Select * from login where EmpId=?");
	try{
	pst3.setString(1,userName);
	ResultSet rs=pst3.executeQuery();		
	rs.next();
	if(rs.getString(3).equals(password))
		out.print("success");
	else
		out.print("fail");
	}catch(Exception e){
		ServletContext sc= this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/Login.jsp");
		rd.include(request,response);
		out.print("fail");
	}
%>

</body>
</html>