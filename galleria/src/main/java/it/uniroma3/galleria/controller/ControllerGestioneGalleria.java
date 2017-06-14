package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.galleria.model.Quadro;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.QuadroService;


@Controller
public class ControllerGestioneGalleria {

	@Autowired
	private QuadroService qs;
	
	@Autowired
	private AutoreService as;

	@GetMapping("/dettagliQuadro")
    public String mostraDettagliQuadro(Model model, @RequestParam(value="quadroId") Long id) {
		model.addAttribute("quadro", this.qs.findById(id));
		return "dettagliQuadro";
	}
	
	@GetMapping("/gestisciGalleria")
    public String mostraQuadri(Model model) {
		model.addAttribute("quadri", this.qs.findAll());
		return "gestisciGalleria";
	}
	

	@PostMapping("/confermaCancellazioneQuadro")
	public String confermaCancellazioneQuadro(Model model,@RequestParam(value="quadroId") Long id){
		model.addAttribute("quadro",qs.findById(id));
		return "confermaCancellazioneQuadro";
	}
	
	@PostMapping("/gestisciGalleria")
	public String cancellaQuadro(Model model,@RequestParam(value="quadroId") Long id){
		qs.removeById(id);
		return mostraQuadri(model);
	}
	
	@PostMapping("/modificaQuadro")
	public String iniziaModificaQuadro(Model model,@RequestParam(value="quadroId") Long id){
		model.addAttribute("quadro", this.qs.findById(id));
		model.addAttribute("autori", this.as.findAll());
		return "modificaQuadro";
	}

	@PostMapping("/dettagliQuadro")
	public String modificaAnnulla(Model model,@RequestParam(required=false,value="modificaQuadro") String modifica,
								@RequestParam(value="titolo") String titolo,@RequestParam(value="anno") String anno,
								@RequestParam(value="tecnica") String tecnica,@RequestParam(value="dimensione") String dimensione,
								@RequestParam(value="autoreId") Long autoreId,@RequestParam(value="quadroId") Long quadroId){
		if(modifica!=null){
			qs.aggiorna(titolo,anno,tecnica,dimensione,as.findById(autoreId),qs.findById(quadroId));
		}
		return mostraDettagliQuadro(model, quadroId);
	}
}
