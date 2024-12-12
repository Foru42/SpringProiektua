package com.DatuAtzipena.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Proba2Controller {

	@GetMapping({"/{id}","/{id}/"})
	public String NahiPath(@PathVariable int id, Model model) {
        model.addAttribute("erabiltzailea", id);
		return "erabiltzaile_profila";
	}
	
	@GetMapping({"/", ""})
	public String home() {
		return "redirect:/admin/1";
	}
}
