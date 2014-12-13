package edu.learn.webdesktop.service;

import edu.learn.webdesktop.domain.Journal;

public interface JournalService {
	
	Journal findJournabyUserName(String username);
}
