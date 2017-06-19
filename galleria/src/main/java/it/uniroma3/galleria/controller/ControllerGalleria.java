package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.QuadroService;

@Controller
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
	
	@PostMapping("/cercaOpera")
	public String cercaOpera(Model model, @RequestParam(value="criterioDiRicerca") String criterio,
											@RequestParam(value="chiaveDiRicerca") String chiave){
		model.addAttribute("quadri", this.qs.findAllByCriterio(chiave, criterio));
		return "cercaOpera";
	}
	
	@GetMapping("/cercaOpera")
	public String visualizzaTutteLeOpere(Model model){
		model.addAttribute("quadri", this.qs.findAll());
		model.addAttribute("autori", this.as.findAll());
		return "cercaOpera";
	}
	
	
	@RequestMapping(value="/cercaOpera",params="confermaCancellazioneQuadro")
	public String quadroRimosso(Model model,@RequestParam(value="quadroId") Long id){
		qs.removeById(id);
		return visualizzaTutteLeOpere(model);
	}
}
