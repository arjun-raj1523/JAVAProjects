<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
</head>
<body>
<h1>hello page</h1>
<h3>${message}</h3>

<form method ="post" action="/gontu_MVC1_NoAnnotations/greeting/formone3">
	<input type="text" name = "studentname">
	<input type="text" name = "studentnumber">
	<input type="submit">
</form>
</body>
</html>