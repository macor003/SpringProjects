package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class ExampleController {

	private static final String EXAMPLE2_VIEW = "example2";

	// localhost:8080/example2/reques1?nm=Mario
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "Usuario") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model1", name);
		return mav;
	}

	// localhost:8080/example2/reques1/Mario
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model2", name);
		return mav;
	}

}
