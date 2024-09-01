package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entity.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PageController {
	@Autowired
	private UserServices userServices;
	
	     @GetMapping("/")      
         public String index() {
	    	 return "redirect:/home";
        	
        }
	
    @RequestMapping("/home")
    public String home(Model model){
        
        // Sending Data to view

        System.out.println("Home page handler ");
        model.addAttribute("name", "Vaibhav Tambe");

        model.addAttribute("Vaibhav", "Sambhajinagar");
        model.addAttribute("git", "https://github.com/Vaibhav9172364566-tambe");

//
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
        	UserForm userForm=new UserForm();
        	//Set as a default data are save karu shakto
//        	userForm.setName("vaibhav");
//        	userForm.setEmail("v@gmail.com");
//        	userForm.setPassword("123");
//        	userForm.setPhoneNumber("123");
//        	userForm.setAbout("...");
        	
        	model.addAttribute("userForm", userForm);
        	
            return  "register";
        }
        
        //Processing register
        
        @RequestMapping(value="/do-register",method=RequestMethod.POST)
        public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rbindingresult, HttpSession session){
        	System.out.println("Processsssssssssss");
        	
        	//fetch the data
        	//UserFrom
        	System.out.println(userForm);
        	//validate from data
        	
        	if(rbindingresult.hasErrors()) {
        		return "register";
        	}
        	
        	//save db
        	//User services
        	
        	
       //UserForm  -->  User 
        	
//      User user=User.builder()
//    		  .name(userForm.getName())
//              .email(userForm.getEmail())
//              .password(userForm.getPassword())
//              .about(userForm.getAbout())
//              .phoneNumber(userForm.getPhoneNumber())
//              .profilePic("https://search.brave.com/images?q=default%20profile%20pictuure")
//    		  .build();
//      
//        User savedUser=	userServices.saveUser(user);
//        	
    
       User user= 	new User();
       user.setName(userForm.getName());
       user.setEmail(userForm.getEmail());
       user.setPassword(userForm.getPassword());
       user.setAbout(userForm.getAbout());
       user.setPhoneNumber(userForm.getPhoneNumber());

      // user.setEnabled(true);
       user.setProfilePic("https://search.brave.com/images?q=default%20profile%20pictuure");
       
       User savedUser=userServices.saveUser(user);
        	System.out.println("saved User success :"); 
        	// messsage ="Register Succefully"
        	
        	//add the message
        	
        	
        	 Message message =  Message.builder()
        			 .content("Registration Successful")
                     .type(MessageType.blue) // Use the correct enum value
                     .build();        	
           session.setAttribute("meassage", " Registration Succefull");
        	//redirction login page
           //
         	
        	
        	return "redirect:/register";
        
       
        }
        
}
