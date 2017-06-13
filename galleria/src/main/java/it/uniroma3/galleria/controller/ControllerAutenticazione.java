package it.uniroma3.galleria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerAutenticazione {
	
	  @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }
	  
	  @GetMapping("/home")
	  public String home(){
		  return "home";
	  }
	  
	  @RequestMapping("/index")
	  public String index(){
		  return "index";
	  }
}
