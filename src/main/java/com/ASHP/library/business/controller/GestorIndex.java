package com.ASHP.library.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ASHP.library.business.entity.Index;



@Controller
public class GestorIndex {

	@PostMapping("/index")
	public String indexLauncher(@ModelAttribute Index index, Model model) {
		return "index";
	}

	@GetMapping("/index")
	public String verTitulo(Model model) {
		
		return "index";
	}
}
