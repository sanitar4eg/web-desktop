package edu.learn.webdesktop.repository;

import edu.learn.webdesktop.domain.Journal;
import edu.learn.webdesktop.domain.User;

public interface JournalDao {

	Journal findByUserName(String username);
}
