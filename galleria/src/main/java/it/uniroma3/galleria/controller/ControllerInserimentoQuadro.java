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

//	@PostMapping("/mostraDatiQuadro")
//	public String mostraDatiQuadro(@RequestParam(value="titolo") String titolo,
//									@RequestParam(value="anno") String anno,
//									@RequestParam(value="dimensione") String dimensione,
//									@RequestParam(value="tecnica") String tecnica,
//									@RequestParam(value="autoreId") Long id,
//									Model model){
//		Quadro quadro = new Quadro();
//		quadro.setTitolo(titolo);
//		quadro.setAnno(anno);
//		quadro.setDimensione(dimensione);
//		quadro.setTecnica(tecnica);
//		quadro.setAutore(as.findById(id));
//		qs.add(quadro);
//		model.addAttribute("quadro", quadro);
//		return "mostraDatiQuadro";
//	}
	
	@PostMapping("/mostraDatiQuadro")
	public String mostraDatiQuadro(@Valid @ModelAttribute Quadro quadro,
								BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
            return inserimentoQuadro(model,quadro);
        }
        else {
        	model.addAttribute(quadro);
            this.qs.add(quadro);
        }
        return "mostraDatiQuadro";
	}
}
