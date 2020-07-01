package com.healthmgmt.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.Appuser;
import com.healthmgmt.app.service.LoginService;

@Controller
@SessionAttributes("name")
@RequestMapping("/healthmgmt")
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping
	public String webget (){
    	System.out.println("App URL /healthmgmt");
		return "login";
	
	}
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
    	System.out.println("in show longin page");
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

       // boolean isValidUser = service.validateUser(name, password);

         Appuser user=service.checkUser(name);
        if (user!=null && password.equals(user.getPassword()))
        {
        	 System.out.println("in login valid user view Home page : "+name);
        	 System.out.println("in login valid user email : "+user.getEmail());
        }
        else
        {
        	System.out.println("in login invalid user view login page : "+name);
        	model.put("errorMessage", "Invalid Credentials");
           return "login";
        }
        
//        if (!isValidUser) {
//            model.put("errorMessage", "Invalid Credentials");
//            return "login";
//        }

        model.put("name", name);
        model.put("password", password);
        
        
        model.addAttribute("user", user);
        
       

        System.out.println("in login success for user : "+name);
        return "redirect:/healthmgmt/Products/getProducts";
    }

}