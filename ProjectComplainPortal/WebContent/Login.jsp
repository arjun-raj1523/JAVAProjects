<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">    
<link href="starter-template.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>   
<script src="js/ie10-viewport-bug-workaround.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	  $("#newUserBody").hide();
	  $("body").css("background-color", "rgba(249, 238, 12, 1)");
	});
	
function newUserShow(){
	$("#loginTab").attr('class', '#'); 
	$("#newUserBody").show();
	$("#loginBody").hide();
	$("#newUserButton").hide();
	
}

function hideLabel() {
    setTimeout(function(){$(".label").fadeOut(2000)}, 2000);
}
</script>
<link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="Login.jsp"> <span class="glyphicon glyphicon-home"></span> Complain Portal</a>
        </div>
        <div class="collapse navbar-collapse">
		   <ul class="nav navbar-nav navbar-right">   
		    <li id="loginTab" class="active"><a href="Login.jsp"><span class="glyphicon glyphicon-user"></span><b> Login</b></span></a></li>                   
		   <li onclick="newUserShow()"><a href="#"><span class="glyphicon glyphicon-plus"></span><b> Sign Up</b></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

<div id="body">

<div id="loginBody">
<form method ="post" action="ControllerServlet" >
<b>Welcome Back!</b><br><br>
<input type="hidden" name="action" value="login">
<input type="text" name="userId" placeholder="Enter User Id" required><br><br>
<input type="password" name="pass" placeholder="Enter Password" required><br><br>
<button type="submit" class="btn btn-success">Login</button><br><br>
</form>

<%
if(request.getAttribute("label")!=null)
{
	if(request.getAttribute("label")=="InvalidUser"){
		out.print("<span class=\"label label-danger\">Invalid User ID</span>");
		out.print("<script>hideLabel()</script>");
}
	
	else if(request.getAttribute("label")=="sameUser"){
		out.print("<span class=\"label label-danger\">Unable To Create Same ID registered</span>");
		out.print("<script>hideLabel()</script>");
	}
	else if(request.getAttribute("label")=="logout"){
		out.print("<span class=\"label label-danger\">Logout Successful</span>");
		out.print("<script>hideLabel()</script>");
	}
	else
		{
			out.print("<span class=\"label label-danger\">Invalid Pass Word</span>");
			out.print("<script>hideLabel()</script>");
	}
}

%>
</div>
<div id="newUserBody">
<form method ="post" action="ControllerServlet" >
<b>Tell me something about Yourself!</b><br><br>
<input type="hidden" name="action" value="newUser">
<input type="text" name="name" placeholder="Enter Name" required><br><br>
<input type="text" name="userId" placeholder="Enter User Id" required><br><br>
<input type="password" name="pass" placeholder="Enter Password" required><br><br>
<input type="text" name="address" placeholder="Enter City" required><br><br>
<button type="submit" class="btn btn-success">Register</button><br><br>
</form>
</div>
</div>
</body>
</html>