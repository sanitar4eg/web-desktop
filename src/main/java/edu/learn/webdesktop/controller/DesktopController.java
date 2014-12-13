package edu.learn.webdesktop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.learn.webdesktop.domain.Journal;
import edu.learn.webdesktop.service.JournalService;

@Controller
public class DesktopController {
	
	@Autowired
	JournalService journalService;

	@RequestMapping(value = "/desktop", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getDesktop(Principal principal) {
		String user = principal.getName();
		Journal journal = journalService.findJournabyUserName(user);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		if (journal != null) {
			modelAndView.addObject("journalName", journal.getName());
			modelAndView.addObject("journalList", journal.getTasks());
		}
		modelAndView.setViewName("desktop");
		return modelAndView;
	}
}
