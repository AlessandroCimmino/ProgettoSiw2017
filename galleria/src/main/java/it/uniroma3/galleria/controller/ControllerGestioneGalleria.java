package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.galleria.service.QuadroService;

@Controller
public class ControllerGestioneGalleria {

	@Autowired
	private QuadroService qs;

	@GetMapping("/dettagliQuadro")
    public String dettagli(Model model,
    						@RequestParam(value="quadroId") Long id) {
		model.addAttribute("quadro", this.qs.findById(id));
		return "dettagliQuadro";
	}
	
	@GetMapping("/gestisciGalleria")
    public String gestisciQuadro(Model model) {
		model.addAttribute("quadri", this.qs.findAll());
		return "gestisciGalleria";
	}
}
