package com.DatuAtzipena.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/bitcoin")
public class BitcoinController {
	@GetMapping({"","/"})
	public String NAhia(@RequestParam (required=false) String nombre, Model model) {
		model.addAttribute("funtzioa", nombre);
		return "hola";
	}
	@GetMapping({"/{id}"})
	public String NahiPath(@PathVariable int id, Model model) {
		model.addAttribute("funtzioa", "Nahidotena");
		model.addAttribute("id", id);
		return "hola";
	}

}
