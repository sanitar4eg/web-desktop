package edu.learn.webdesktop.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.learn.webdesktop.domain.User;

@Controller
public class RegestrationController {

	@RequestMapping(value = "/registration**", method = RequestMethod.GET)
	public String getRegistration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
}
