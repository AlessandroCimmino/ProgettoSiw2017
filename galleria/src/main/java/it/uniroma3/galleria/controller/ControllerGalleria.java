package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.QuadroService;

public class ControllerGalleria {
	
	@Autowired
	private AutoreService as;
	
	@Autowired
	private QuadroService qs;
	
	@GetMapping("/galleria")
	public String visualizzaGalleria(Model model){
		model.addAttribute("quadri", this.qs.findAll());
		model.addAttribute("autori", this.as.findAll());
		return "galleria";
	}
}
