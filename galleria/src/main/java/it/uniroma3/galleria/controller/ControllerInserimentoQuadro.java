package it.uniroma3.galleria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import it.uniroma3.galleria.service.AutoreService;

@Controller
public class ControllerInserimentoQuadro {

	@GetMapping("/inserimentoQuadro")
    public String inserimentoQuadro(Model model) {
		AutoreService aService = new AutoreService();
        model.addAttribute("autori", aService.findAll());
        return "inserimentoQuadro";
    }
}
