package edu.learn.webdesktop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.learn.webdesktop.domain.User;
import edu.learn.webdesktop.service.UserService;

@Controller
public class RegestrationController {
	
	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory
			.getLogger(WelcomeController.class);
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postRegistration(@ModelAttribute("userForm") User user, 
			Model model) {
		logger.info(user.getPassword() + " " + user.getUserName());
		userService.addUser(user);
		return "registrationSuccess";
	}
}
