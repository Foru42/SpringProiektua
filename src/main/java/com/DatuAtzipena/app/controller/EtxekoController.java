package com.DatuAtzipena.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DatuAtzipena.app.domain.erabiltzailea;
import com.DatuAtzipena.app.repository.ErabiltzaileaRepository;

import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/erabiltzailea")
public class EtxekoController {

	@Autowired
	private ErabiltzaileaRepository erabiltzaileaRepo;

	private static final List<erabiltzailea> erabiltzaileak = Arrays.asList(new erabiltzailea( "Kepa", "Arana"),
			new erabiltzailea( "Marta", "Gutierrez"), new erabiltzailea( "Mikel", "Urki"));

	@GetMapping({ "/", "" })
	public String zerrendatu(Model model) {
		model.addAttribute("erabiltzaileak", erabiltzaileak);
		erabiltzailea e= new erabiltzailea( "Kepa", "Arana");
		erabiltzaileaRepo.save(e);
		return "zerrenda";
	}

	@GetMapping("/sartu")
	public String insert(Model model) {
		//erabiltzailea e= new erabiltzailea(1, "Kepa", "Arana");
		//erabiltzaileaRepo.save(e);
		List<erabiltzailea> erabiltzaileak = erabiltzaileaRepo.findAll();
	    model.addAttribute("erabiltzaileak", erabiltzaileak);
		return  "zerrenda";
		
	}	
	
	@GetMapping("/ikusi")
	public String ikusiErabiltzailea(@RequestParam(required = false) String izena, String abizena, Model model) {		
		erabiltzailea e= new erabiltzailea(izena,abizena);
		erabiltzaileaRepo.save(e);
		List<erabiltzailea> erabiltzaileak = erabiltzaileaRepo.findAll();
	    model.addAttribute("erabiltzaileak", erabiltzaileak);
		return  "redirect:/erabiltzailea";
		
	}
	
	/*@GetMapping("/{id}")
	public String NahiPath(@PathVariable int id, Model model) {
		 erabiltzailea encontrado = erabiltzaileaRepo.findById(id).orElse(null);
		model.addAttribute("erabiltzailea", encontrado);
		return "zerrenda";
	} */
	
	
	@GetMapping("/new")
	public String Formularioa(Model model) {	
		erabiltzailea erab = new erabiltzailea();
		model.addAttribute("erabiltzailea", erab);
		return "Formularioa";
		
	}
	
	@PostMapping("/new/submit")
	public String enviar(@ModelAttribute erabiltzailea erabiltzaile) {
		erabiltzaileaRepo.save(erabiltzaile);
		return "redirect:/erabiltzailea/sartu";
		
	}
	
	@GetMapping("/edit/{id}")
	public String EditatuForm(@PathVariable("id")int id, Model model) {
		model.addAttribute("erabiltzailea", erabiltzaileaRepo.findById(id));
		return  "Formularioa";
		
	}
	@GetMapping("/delete/{id}")
	public String DeleteForm(@PathVariable("id")int id) {
		erabiltzaileaRepo.deleteById(id);
		return  "redirect:/erabiltzailea/sartu";
		
	}
	
}