<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jstl/core_rt' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portal</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">    
<link href="starter-template.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>   
<script src="js/ie10-viewport-bug-workaround.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="style1.css">
<script>
$(document).ready(function(){
	  $("#launchComplain").hide();
	  $("#complainStatus").hide();
	  $("#searchComplain").hide();
	  $("#searchCustomer").hide();
	  $("#resultName").hide();	  
	  $("body").css("background-color", "rgba(249, 238, 12, 1)");
	  $(".progress").hide();
	});
	
function changeTitleLaunch(){
	document.title="Launch Complain";
	$("#StatusComplainTab").attr('class', '#');
	$("#AllCustomerDetailTab").attr('class', '#');
	$("#CustomerComplainSearchTab").attr('class', '#');
	$("#launchComplainTab").attr('class', 'active');
	$("#launchComplain").show();
	$("#complainStatus").hide();
	$("#showcustomerDetails").hide();
	$("#searchComplain").hide();
	$("#searchCustomer").hide();
	$("#result").hide();
	$("#resultID").hide();
	$("#resultName").hide();
	$(".navbar-inverse").css("background-color", "rgba(207, 16, 16, 1)");
	
}
function changeTitleStatus(){
	document.title="Check Status";
	$("#launchComplainTab").attr('class', '#');
	$("#AllCustomerDetailTab").attr('class', '#');
	$("#CustomerComplainSearchTab").attr('class', '#');
	$("#StatusComplainTab").attr('class', 'active');
	$("#launchComplain").hide();
	$("#complainStatus").show();
	$("#searchComplain").hide();
	 $("#showcustomerDetails").hide();
	 $("#searchCustomer").hide();
	 $("#result").hide();
	 $("#resultName").hide();
	$(".navbar-inverse").css("background-color", "rgba(62, 60, 164, 1)");
	
	}
function changeTitleCusDetails(){
	document.title="Show All Customers";
	$("#StatusComplainTab").attr('class', '#');
	$("#launchComplainTab").attr('class', '#');
	$("#CustomerComplainSearchTab").attr('class', '#');
	$("#AllCustomerDetailTab").attr('class', 'active');
	$("#launchComplain").hide();
	$("#searchComplain").hide();
	$("#complainStatus").hide();
	$("#searchCustomer").show();
	$("#resultName").hide();
	$("#resultID").hide();
	$("#result").hide();
	$(".navbar-inverse").css("background-color", "rgba(158, 60, 164, 1)");
	$(".progress").hide();
	
	}
function changeTitleSearch(){
	document.title="Search Customer";
	$("#StatusComplainTab").attr('class', '#');
	$("#launchComplainTab").attr('class', '#');
	$("#AllCustomerDetailTab").attr('class', '#');
	$("#CustomerComplainSearchTab").attr('class', 'active');
	$("#launchComplain").hide();
	$("#complainStatus").hide();
	$("#searchComplain").show();
	$("#showcustomerDetails").hide();
	$("#searchCustomer").hide();
	$("#result").hide();
	$("#resultName").show();
	$("#resultID").hide();
	$(".navbar-inverse").css("background-color", "rgba(60, 164, 61, 1)");
	
	}
function hideLabel() {
    setTimeout(function(){$(".label").fadeOut(2000)}, 2000);
}
var temp=0;
function showComplain(count){
	if(temp==0)
	{
	$("#hideComplain-"+count).show();
	temp++;
	}
	else
	{
		$("#hideComplain-"+count).hide();
		temp--;
	}
	
}
function showProgress(){
	
	$(".progress").show()
}
</script>
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
          <a class="navbar-brand" href="ComplainPortal.jsp"> <span class="glyphicon glyphicon-home"></span> Complain Portal</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li id="launchComplainTab" class="#" onclick="changeTitleLaunch()"><a href="#"><span class="glyphicon glyphicon-pencil"></span> <b>Launch Complain</b></span></a></li>                   
          	<li id="StatusComplainTab" class="#" onclick="changeTitleStatus()"><a href="#"><span class="glyphicon glyphicon-asterisk"></span> <b>Complain Status</b></span></a></li>
          	<li id="AllCustomerDetailTab" class="#" onclick="changeTitleCusDetails()"><a href="#"><span class="glyphicon glyphicon-th-list"></span><b> All Customers with Complains</b></span></a></li>
          	<li id="CustomerComplainSearchTab" class="#" onclick="changeTitleSearch()"><a href="#"><span class="glyphicon glyphicon-search"></span><b> Search Customer Complain</b></span></a></li>
         	<li><a href="ControllerServlet"><span class="glyphicon glyphicon-off"></span><b> Logout</b></a></li> 
         
          </ul>
		   <ul class="nav navbar-nav navbar-right">  
		    </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
<div id="body">


<div id="launchComplain">
<form method="post" action="ControllerServlet">
<input type="hidden" name="action" value="launchComplain">
<select name="complainDropDown">
  <option value="entercomplain" selected>Enter Complain</option>
  <option value="Hardware Issue">Hardware Issue</option>
  <option value="Software Issue">Software Issue</option>
</select><br><br>
<button type="submit" class="btn btn-primary">Submit Complain</button>
</form>


</div>
<%
if(request.getAttribute("label")!=null)
{
	if(request.getAttribute("label")=="success"){
out.print("<span class=\"label label-success\">Complain Logged</span>");
out.print("<script>hideLabel()</script>");
out.print("<script>changeTitleLaunch()</script>");
}
	else
		{
			out.print("<span class=\"label label-danger\">Complain NOT Logged</span>");
		 	out.print("<script>hideLabel()</script>");	
	}
}
%>

<div id="complainStatus">
<form method="post" action="ControllerServlet">
<input type="text" name="complainID" id="complainID"  class="form-control" placeholder="Enter ID" required>
<input type="hidden" name="action" value="complainstatus">
<button type="submit" class="btn btn-primary">Check Status</button>
</form>
</div>
<div id="resultID">
<c:forEach var="item" items="${complainStatus}">
   <b><c:out value="${item}" /></b><br>  
</c:forEach>
</div>

<div id="searchCustomer">
<form method="post" action="ControllerServlet">
<input type="hidden" name="action" value="searchCustomer">
<select name="complainDropDown">
  <option value="entercomplain" selected>Enter Complain</option>
  <option value="Hardware Issue">Hardware Issue</option>
  <option value="Software Issue">Software Issue</option>
</select><br><br>
<button type="submit" class="btn btn-primary" onclick="showProgress()">Search</button>
</form>

<div class="progress">
  <div class="progress-bar progress-bar-warning progress-bar-striped active"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
    <span class="sr-only"></span>
  </div>
</div>

</div>

<div id="result">
<c:forEach var="item" items="${nameList}">
   <b><c:out value="${item}" /></b><br>  
</c:forEach>
</div>


<div id="searchComplain">
<form method="post" action="ControllerServlet">
<input list="customerName" name="customerName" class="form-control" autocomplete="off">
<datalist id="customerName">
<c:forEach var="item" items="${nameListSearch}">
  <option value="<c:out value="${item}" />">
</c:forEach>  
</datalist>
<input type="hidden" name="action" value="customerNameSearch">
<button type="submit" class="btn btn-primary">Search Customer</button>
</form>
</div>

<div id="resultName">
<table class="table table-bordered">
<tr>
	<th>Complain ID</th>
	<th>Complain Topic</th>
</tr>
<c:forEach var="item" items="${complainmap}">
   <tr>
    <td><c:out value="${item.key}" /></td>
    <td><c:out value="${item.value}" /></td>
   </tr>  
</c:forEach>
</table>
</div>


<script src="js/bootstrap.min.js"></script>
<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>