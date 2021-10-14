package br.com.acme.fakeecomerce.timezone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	

	@RequestMapping(path = { "", "home" })
	public String home(Model model) {
		return "index";
	}

	
}
