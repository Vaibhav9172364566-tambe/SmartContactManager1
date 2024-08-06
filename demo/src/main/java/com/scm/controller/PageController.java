package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        
        // Sending Data to view

        System.out.println("Home page handler ");
        model.addAttribute("name", "Vaibhav Tambe");

        model.addAttribute("Vaibhav", "Sambhajinagar");
        model.addAttribute("git", "https://github.com/Vaibhav9172364566-tambe");


        return "home";
    }
    
    // about route
        @RequestMapping("/about")
        public String aboutPage(Model model) {
        	model.addAttribute("isLogin", true);
        	
        	System.out.println("About page loading");
            return "about";
        }
        
        //Services
        @RequestMapping("/services")
        public String servicesPage() {
        	System.out.println("services page loading");
            return "services";
        }
        @GetMapping("/contact")
        public String contact() {
            return new String("contact");
        }
        
        @GetMapping("/login")
        public String login() {
            return new String("login");
        }
        @GetMapping("/register")
        public String register(Model model) {
        	UserForm userFrom=new UserForm();
        	//Default are insert karu shakto
        	
        	 
        	model.addAttribute("userForm",userFrom);
        	
        	
        	
            return  "register";
        }
        
        //Processing register
        
        @RequestMapping(value ="/do-register",method = RequestMethod.POST)
        public String processRegister() {
        	
        	System.out.println("Processing  registration");
        	
        	//fetch the data
        	//useForm
        	
        	
        	// validate  from data
        	//save to db
        	//message="Registsration"
        	//redirect login page
        	
        	return "redirect:/register";
        }
        
}
