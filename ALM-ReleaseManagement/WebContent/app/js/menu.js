$(document).ready(function(){
			$("#sub-menu-release" ).hide();
			$("#sub-menu-iteration" ).hide();
			$(".menu-container" ).on( "mouseenter", function() {
				$(".menu-container").animate({left:'80px'});
			}).on( "mouseleave", function() {
				$(".menu-container").animate({left:'0px'});
			});	
			$("#release" ).click(function() {
				$("#main-menu").animate({left:'-80px'},"fast", function() {
					$("#main-menu" ).hide();
					$("#sub-menu-release").show();
					$("#sub-menu-release").css("left","-80px");
					$("#sub-menu-release").animate({left:'0px'});
				});
			});	
			$("#sub-menu-release #back" ).click(function() {
				$("#sub-menu-release").animate({left:'-80px'},"fast", function() {
					$("#main-menu" ).show();
					$("#main-menu").animate({left:'0px'});
				});
			});
			$("#iteration" ).click(function() {
				$("#main-menu").animate({left:'-80px'},"fast", function() {
					$("#main-menu" ).hide();
					$("#sub-menu-release" ).hide();
					$("#sub-menu-iteration").show();
					$("#sub-menu-iteration").css("left","-80px");
					$("#sub-menu-iteration").animate({left:'0px'});
				});
			});	
			$("#sub-menu-iteration #back" ).click(function() {
				$("#sub-menu-iteration").animate({left:'-80px'},"fast", function() {
					$("#main-menu" ).show();
					$("#main-menu").animate({left:'0px'});
				});
			});
		});