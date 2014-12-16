package edu.learn.webdesktop.service.widgetservice;

public class JournalProvider implements Provider {
	
	@Override
	public WidgetService createService() {
		return new JournalService();
	}
}
