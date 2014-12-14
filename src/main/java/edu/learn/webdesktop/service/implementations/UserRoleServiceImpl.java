package edu.learn.webdesktop.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.learn.webdesktop.domain.UserRole;
import edu.learn.webdesktop.repository.UserRoleDao;
import edu.learn.webdesktop.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	UserRoleDao userRoleDao;

	@Override
	public void addUserRole(UserRole userRole) {
		userRoleDao.addUserRole(userRole);
	}
}
