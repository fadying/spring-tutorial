package com.ouyang.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ouyang.test.web.helper.EntityGenerator;

import java.util.Date;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@Autowired
	EntityGenerator entityGenerator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMenu(Model model) {
		model.addAttribute("today", new Date());
		return "index";
	}

	@PostConstruct
	public void prepareFakeDomain() {
		entityGenerator.deleteDomain();
		entityGenerator.generateDomain();
	}
}