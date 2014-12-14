package edu.learn.webdesktop.repository.implementations;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.learn.webdesktop.domain.UserRole;
import edu.learn.webdesktop.repository.UserRoleDao;

@Repository
@Transactional
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().save(userRole);
	}

}
