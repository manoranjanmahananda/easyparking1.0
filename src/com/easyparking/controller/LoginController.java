package com.easyparking.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Apple
 *
 */
@Controller

public class LoginController {
	
	/**
	 * Method for handling file download request from client
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		

	}
	
	@RequestMapping("/login")  
    public ModelAndView loginPage() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("login", "message", message);  
    }
	
	@RequestMapping("/loginprocess")  
    public ModelAndView loginProcess(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String username=request.getParameter("email");
		System.out.println("Email is :::"+username);
		String password=request.getParameter("password");
		System.out.println("password is :::"+password);
		
		Map<String,String> loginMap=new HashMap<String,String>();
		loginMap.put("email", username); 
        return new ModelAndView("loginsuccess","loginMap",loginMap);  
    }

}
