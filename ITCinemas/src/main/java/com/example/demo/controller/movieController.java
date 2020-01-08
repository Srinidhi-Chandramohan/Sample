package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.service.movieService;

@Controller
@ResponseBody
public class movieController {
	
	
	@Autowired
	movieService service;
	
	Admin admin =new Admin();
	
	@GetMapping("/")
	public ModelAndView myFn(){
		ModelAndView model=new ModelAndView();
		model.setViewName("File1");
		model.addObject("sri");
		return model;
	}
	
	@GetMapping("/AdminSignUp")
	public ModelAndView adminSignUp(){
		ModelAndView model=new ModelAndView();
		model.setViewName("AdminSignUp");
		model.addObject("signUp");
		return model;
	}
	

	@PostMapping(value="/AdminSignUp", produces = {"application/json", "application/xml"}
    ,  consumes = {"application/x-www-form-urlencoded"})
	public ModelAndView signUpStatus(@RequestBody Admin ad){
		ModelAndView m=new ModelAndView();
           if(service.adminSignUp()) {
        	   m.setViewName("Welcome");
			m.addObject("success", "You have successfully created an account"+ admin.getUserName()+"!");
		}
		else
		{
			 m.setViewName("Failed");
			m.addObject("failed","No new account has been created");
			
		}
		return m;
		}
		
			
	
	@GetMapping("/Movie")
	public ModelAndView addMovies() {
		ModelAndView model=new ModelAndView();
		model.setViewName("NewFile");
		model.addObject("deloitte");
		
		return model;
	}




}
