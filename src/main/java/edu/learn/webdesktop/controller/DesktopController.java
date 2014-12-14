package edu.learn.webdesktop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.learn.webdesktop.domain.Journal;
import edu.learn.webdesktop.domain.User;
import edu.learn.webdesktop.service.JournalService;
import edu.learn.webdesktop.service.UserService;

@Controller
public class DesktopController {
	
	@Autowired
	JournalService journalService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/desktop", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getDesktop(Principal principal, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.findByUserName(principal.getName());
		modelAndView.addObject("user", user.getUserName());
		
		List<String> widgetsList = new ArrayList<String>();
		widgetsList.add("Journal");
		widgetsList.add("Calculator");
		modelAndView.addObject("widgetsList", widgetsList);
		List<String> widgets = new ArrayList<String>();
		modelAndView.addObject("widgets", widgets);
		model.addAttribute("customerForm", user.getArrayOfWidgetsName());
		
		Journal journal = journalService.findJournabyUserName(user.getUserName());
		if (journal != null) {
			modelAndView.addObject("journalName", journal.getName());
			modelAndView.addObject("journalList", journal.getTasks());
		}
		modelAndView.setViewName("desktop");
		return modelAndView;
	}
	
	/*@RequestMapping(value = "/desktop", method = RequestMethod.POST)
	public ModelAndView postDeskrop() {
		ModelAndView modelAndView = new ModelAndView();
		
		
		return modelAndView;
	}*/
}
