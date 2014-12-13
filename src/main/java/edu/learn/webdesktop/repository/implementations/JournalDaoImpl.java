package edu.learn.webdesktop.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.learn.webdesktop.domain.Journal;
import edu.learn.webdesktop.repository.JournalDao;

@Repository
@Transactional
public class JournalDaoImpl implements JournalDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public Journal findByUserName(String username) {
		List<Journal> journals = new ArrayList<Journal>();
		if (username != null) {
			journals = sessionFactory.getCurrentSession()
					.createQuery("from Journal where username=?")
					.setParameter(0, username).list();
		}
		if (journals.size() > 0) {
			return journals.get(0);
		} else {
			return null;
		}
	}
}
