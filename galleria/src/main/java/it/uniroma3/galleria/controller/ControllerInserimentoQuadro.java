package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.galleria.model.Quadro;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.QuadroService;

@Controller
public class ControllerInserimentoQuadro {
	
	@Autowired
	private AutoreService as;
	@Autowired
	private QuadroService qs;

	@GetMapping("/inserimentoQuadro")
    public String inserimentoQuadro(Model model,Quadro quadro) {
        model.addAttribute("autori", as.findAll());
        return "inserimentoQuadro";
    }
	
	@PostMapping("/mostraDatiInserimentoQuadro")
	public String mostraDatiInserimentoQuadro(@Valid @ModelAttribute Quadro quadro,
								BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
            return inserimentoQuadro(model,quadro);
        }
        else {
        	model.addAttribute(quadro);
            this.qs.add(quadro);
        }
        return "mostraDatiInserimentoQuadro";
	}
}
