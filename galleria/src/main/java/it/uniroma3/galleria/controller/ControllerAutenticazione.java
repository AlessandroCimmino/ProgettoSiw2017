package it.uniroma3.galleria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerAutenticazione {
	
	  @RequestMapping("/login")
	  public String login() {
	    return "login";
	  }
	  
	  
}
