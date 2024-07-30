package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
        
        

}
