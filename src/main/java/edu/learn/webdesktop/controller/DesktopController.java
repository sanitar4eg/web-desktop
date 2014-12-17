package edu.learn.webdesktop.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.learn.webdesktop.domain.Journal;
import edu.learn.webdesktop.domain.User;
import edu.learn.webdesktop.domain.Widget;
import edu.learn.webdesktop.service.JournalService;
import edu.learn.webdesktop.service.UserService;

@Controller
public class DesktopController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DesktopController.class);
	
	@Autowired
	JournalService journalService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/desktop", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ModelAndView getDesktop(Principal principal, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.findByUserName(principal.getName());
		
		modelAndView.addObject("user", user.getUserName());
		
		List<Widget> widgetsList = Arrays.asList(
				new Widget(user, "Journal"),
				new Widget(user, "Calculator"));
		modelAndView.addObject("widgetsList", widgetsList);
		
		modelAndView.addObject("userEntity", user);
		
		Journal journal = journalService.findJournabyUserName(user.getUserName());
		if (journal != null) {
			modelAndView.addObject("journalName", journal.getName());
			modelAndView.addObject("journalList", journal.getTasks());
		}
		modelAndView.setViewName("desktop");
		return modelAndView;
	}
	
	@RequestMapping(value = "/desktop/resultwidgets")
	public ModelAndView postDeskrop(@ModelAttribute("userEntity") Object userEntity,Model model) {
		
		ModelAndView modelAndView = new ModelAndView("resultwidgets");
		//modelAndView.addObject("usersWidgets", userEntity);		
		return modelAndView;
	}
}
