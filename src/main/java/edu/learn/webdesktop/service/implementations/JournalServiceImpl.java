package edu.learn.webdesktop.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.learn.webdesktop.domain.Journal;
import edu.learn.webdesktop.repository.JournalDao;
import edu.learn.webdesktop.service.JournalService;

@Service
public class JournalServiceImpl implements JournalService {

	@Autowired
	JournalDao journalDao;

	@Override
	public Journal findJournabyUserName(String username) {
		return journalDao.findByUserName(username);
	}
}
