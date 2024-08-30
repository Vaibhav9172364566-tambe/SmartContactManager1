// Protected url


package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")

public class UserController {
	
	//user dashboard page
	
	@RequestMapping(value="/dashboard")
	public String userDashboard() {
		System.out.println("user dashboard");
		return "/user/dashboard";
	}
	
	//user Profile page
	
	@RequestMapping(value="/profile")
	public String userProfile() {
		System.out.println("user profile");
		return "/user/profile";
	}
	
	//user add contact page
	//user view contact

}
