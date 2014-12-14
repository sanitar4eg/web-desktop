package edu.learn.webdesktop.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.learn.webdesktop.domain.User;
import edu.learn.webdesktop.domain.UserRole;
import edu.learn.webdesktop.repository.UserDao;
import edu.learn.webdesktop.service.UserRoleService;
import edu.learn.webdesktop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRoleService userRoleService;
	
	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void addUser(User user) {
		user.setEnabled(true);
		userDao.addUser(user);
		userRoleService.addUserRole(new UserRole(user,"USER"));
	}
}
