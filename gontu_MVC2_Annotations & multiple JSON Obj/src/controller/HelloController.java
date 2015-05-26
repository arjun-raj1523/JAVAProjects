package controller;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import model.IterationEntity;
import model.StudentClass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


//import org.springframework.web.servlet.mvc.AbstractController;

@Controller

@RequestMapping("/greeting")
public class HelloController {

	public HelloController() {
		System.out.println("HelloController const");
	}	
	
	
	/* Cannot make JSON object to work
	@RequestMapping(value = "/welcome1",method = RequestMethod.GET)
	protected @ResponseBody IterationEntity JSONeg1() throws Exception 
	{		
		IterationEntity obj  = new IterationEntity("title","description","startDate","endDate","items","status","type");
		return obj ;		
	}*/
	
	//Runs but we can only send the object as a string
	@RequestMapping("/Iteration/ToString/{index}")
	protected @ResponseBody String JSONeg(@PathVariable("index") String index) throws Exception 
	{		
		IterationEntity obj  = new IterationEntity(Integer.parseInt(index),"title","desc","startDate","endDate","items","status","type");
		return obj.toString();		
	}
	
	//Runs but we can only send the object as a string
		@RequestMapping("/Iteration/ToJSON/{index}")
		protected @ResponseBody String JSONeg2(@PathVariable("index") String index) throws Exception 
		{			
			IterationEntity obj1  = new IterationEntity(Integer.parseInt(index),"title","desc","startDate","endDate","items","status","type");
			return obj1.toHuz();		
		}
	
	@RequestMapping("/Iteration/ToJSONobj")
	protected @ResponseBody String JSONeg3() throws Exception 
	{			
		IterationEntity obj1  = new IterationEntity(1,"title","desc","startDate","endDate","items","status","type");
		IterationEntity obj2  = new IterationEntity(2,"title","desc","startDate","endDate","items","status","type");
		
		//return "[{\"firstName\":\"Jason\",\"lastName\":\"Smith\"},{\"firstName\":\"Joan\",\"lastName\":\"Smith\"},{\"firstName\":\"Jennifer\",\"lastName\":\"Jones\"}]" ;
		return "["+obj1.toSilly()+","+obj2.toSilly()+"]";
	}	
		
	@RequestMapping("/welcome/{username}/{hobby}")
	protected ModelAndView handleRequestInternal1(@PathVariable("username") String name,@PathVariable("hobby") String hobby) throws Exception 
	{
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("message","The hobby of "+name+" is "+hobby);
		return model;
	}
	
	@RequestMapping("/welcome/hellopage")
	protected ModelAndView handleRequestInternal2() throws Exception 
	{
		ModelAndView model = new ModelAndView("AngularReadJSON");
		
		return model;
	}
	
	/* DID NOT WORK
	@RequestMapping("/welcome/{username}/{hobby}")
	protected ModelAndView handleRequestInternal2(@RequestBody Map<String,String>pathVars) throws Exception 
	{
		ModelAndView model = new ModelAndView("HelloPage");
		String name = pathVars.get("username");
		String hobby = pathVars.get("hobby");
		model.addObject("message","The hobby of "+name+" is "+hobby);
		return model;
	}*/
	
	
	//Works with Request Method Post
	@RequestMapping(value ="/formone1" , method=RequestMethod.POST)
	public ModelAndView formTest2(@RequestParam("studentname")String studentname,@RequestParam("studentnumber")String studentnumber)
	{
		ModelAndView model = new ModelAndView("DisplayFormData");
		model.addObject("studentname","studentname");
		model.addObject("studentnumber","studentnumber");
		return model;
		
	}
	
	//Works with Map of RequestParam
	@RequestMapping(value ="/formone2" , method=RequestMethod.POST)
	public ModelAndView formTest3(@RequestParam Map<String,String> reqParam)
	{
		ModelAndView model = new ModelAndView("DisplayFormData");
		model.addObject("studentname",reqParam.get("studentname"));
		model.addObject("studentnumber",reqParam.get("studentnumber"));
		return model;
		
	}
	
	//@ModelAttribute
	@RequestMapping(value ="/formone3" , method=RequestMethod.POST)
	public ModelAndView formTest4(@ModelAttribute ("studentone") StudentClass stu)
	{
		
		ModelAndView model = new ModelAndView("DisplayFormModel");
		return model;
		
	}
}