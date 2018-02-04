package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSE_VIEW = "courses";

	private static final Log logger = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		logger.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSE_VIEW);
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		logger.info("Call: " + "addCourse() " + "--- Param: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listcourses";
	}

	@PostMapping("/removecourse")
	public String removeCourse(@ModelAttribute("course") Course course) {
		logger.info("Call: " + "removeCourse() " + "--- Param: " + course.toString());
		courseService.removeCourse(course.getId());
		return "redirect:/courses/listcourses";
	}

}
