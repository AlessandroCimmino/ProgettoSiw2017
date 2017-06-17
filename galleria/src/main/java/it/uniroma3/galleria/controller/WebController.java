package it.uniroma3.galleria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
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
    
    @RequestMapping("/login-error")
    public String loginError(Model model) {
      model.addAttribute("loginError", true);
      return "login";
    }
   
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}