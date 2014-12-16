package edu.learn.webdesktop.service.widgetservice;

import org.springframework.web.servlet.ModelAndView;

import edu.learn.webdesktop.domain.User;

public interface WidgetService {
	ModelAndView getMavForWidget(User user, ModelAndView modelAndView);
	
	ModelAndView postMavForWidget(User user, ModelAndView modelAndView);
}
