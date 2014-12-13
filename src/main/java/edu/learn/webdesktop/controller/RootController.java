package edu.learn.webdesktop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public ModelAndView getHome() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Web Desktop Application");
		model.addObject("message", "Welcome Page !");
		model.setViewName("home");
		return model;
	}
}
