package controller;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;




import model.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.AbstractController;




@Controller
@RequestMapping("/greeting")
public class HelloController {
	
	@Autowired
	private HelloWorld obj;	
	
	
	@RequestMapping("/depdencyTest")
	public ModelAndView depTest()
	{
		
		ModelAndView model = new ModelAndView("DisplayFormModel");	
	    
		model.addObject("helloData",obj.method());
		return model;
		
	}
	
}