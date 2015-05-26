$(document).ready(function(){
	  $("#launchComplain").hide();
	  $("#complainStatus").hide();
	  $("#searchComplain").hide();
	  $("#searchCustomer").hide();
	  $("#resultName").hide();	  
	  $("body").css("background-color", "rgba(228, 251, 252, 1)");
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