package edu.learn.webdesktop.service.widgetservice;

import org.springframework.web.servlet.ModelAndView;

import edu.learn.webdesktop.domain.User;

public class CalculatorService implements WidgetService {

	@Override
	public ModelAndView getMavForWidget(User user, ModelAndView modelAndView) {
		return modelAndView;
	}

	@Override
	public ModelAndView postMavForWidget(User user, ModelAndView modelAndView) {
		return modelAndView;
	}

}
