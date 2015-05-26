package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.model.Login;

public class LoginCheck extends SimpleFormController {
	
	 public LoginCheck() {
	    	
	      setCommandClass(Login.class);
	       
	      System.out.println("in logincheck constr");
	  
	    }

	    @Override
	    protected ModelAndView onSubmit(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3) throws Exception {
	        ModelAndView mv=new ModelAndView();
	        Login l1=(Login)arg2;
	        if(l1.getUsername().equals("admin") && l1.getPassword().equals("admin"))
	            mv.setViewName(getSuccessView());
	        else
	            mv.setViewName(getFormView());
	          mv.addObject("user",l1.getUsername());
	        return mv;
	    }


}
