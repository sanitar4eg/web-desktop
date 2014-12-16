package edu.learn.webdesktop.service.widgetservice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class WidgetServicesImpl implements WidgetServices {

	public WidgetServicesImpl() {
		providers.put("Journal", new JournalProvider());
		providers.put("Calculator", new CalculatorProvider());
	}

	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

	public static void registerProvider(String name, Provider provider) {
		providers.put(name, provider);
	}

	public static WidgetService newInstance(String name)
			throws IllegalArgumentException {
		Provider provider = providers.get(name);
		if (provider == null) {
			throw new IllegalArgumentException("Provider not found");
		}
		return provider.createService();
	}

}
