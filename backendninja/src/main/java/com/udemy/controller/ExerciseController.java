package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.service.ExerciseService;

@Controller
@RequestMapping("/ejercicio")
public class ExerciseController {

	private static final Log logger = LogFactory.getLog(ExamplePost.class);

	private static final String TEMPLATE_EXERCISE = "exercise1";

	@Autowired
	@Qualifier("exerciseService")
	private ExerciseService exerciseService;

	// @GetMapping("/")
	// public String redirect() {
	// return "redirect:/ejericio/exampleString";
	// }

	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/ejercicio/showmessage");
	}

	@GetMapping("exampleMessage")
	public String exampleMessage(Model model) {
		model.addAttribute("message", "mensaje");
		return TEMPLATE_EXERCISE;
	}

	@GetMapping("showmessage")
	public ModelAndView showMessage() {
		exerciseService.getMessage();
		ModelAndView mav = new ModelAndView(TEMPLATE_EXERCISE);
		mav.addObject("message", "mensaje MAV");
		return mav;
	}
}
