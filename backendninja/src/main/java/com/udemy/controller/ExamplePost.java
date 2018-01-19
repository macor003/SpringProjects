package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/examplePost")
public class ExamplePost {

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";

	// Redireccionar forma 1
	// @GetMapping("/")
	// public String redirect() {
	// return "redirect:/examplePost/showform";
	// }

	// Redireccionar forma 2
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/examplePost/showform");
	}

	@GetMapping("showform")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}

	@PostMapping("/addperson")
	public ModelAndView addperson(@ModelAttribute("person") Person person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		return mav;

	}

}
