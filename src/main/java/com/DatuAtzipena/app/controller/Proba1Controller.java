package com.DatuAtzipena.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class Proba1Controller {
	@GetMapping({"/hasiera"})
	public String ikusi() {

		return "index";
	}
	
	 @GetMapping({"/"})
	    public String NAhia(@RequestParam(required = false, name = "erabiltzailea") Integer erabiltzailea, Model model) {
	        model.addAttribute("erabiltzailea", erabiltzailea);
	        return "erabiltzaile_profila";
	    }
}
