<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="l1" class="Login.Login"/>
<jsp:setProperty name="l1" property="uid"  />
<jsp:setProperty name="l1" property="pass"  />
User Id:
<jsp:getProperty name="l1" property="uid" /><br>
Password:
<jsp:getProperty name="l1" property="pass" /><br>

<%out.print(l1.isValid()); %>
</body>
</html>