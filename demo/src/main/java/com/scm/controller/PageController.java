package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
