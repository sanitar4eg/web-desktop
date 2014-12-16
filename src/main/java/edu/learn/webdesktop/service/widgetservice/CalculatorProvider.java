package edu.learn.webdesktop.service.widgetservice;

public class CalculatorProvider implements Provider {

	@Override
	public WidgetService createService() {
		return new CalculatorService();
	}

}
