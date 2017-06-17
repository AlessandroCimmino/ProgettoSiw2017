package it.uniroma3.galleria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class WebController {
   
    @RequestMapping(value={"/","home"})
        public String home(){
            return "home";
        }
   
  
    @RequestMapping(value="/gestisciGalleria")
    public String gestisciGalleria(){
        return "gestisciGalleria";
    }
   
    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }
    
    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login";
    }
   
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
    
    @RequestMapping(value="/logout")
    public String logout(){
    	return "logout";
    }
}