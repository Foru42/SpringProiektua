package com.DatuAtzipena.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/indexeo")
public class IndexController {
	
		@GetMapping({"","/"})
		public String index() {
			return "hola";
		}
		@GetMapping({"/pepito"})
		public String home() {
			return "redirect:/bitcoin/";
		}

}
