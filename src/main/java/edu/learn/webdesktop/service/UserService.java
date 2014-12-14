package edu.learn.webdesktop.service;

import edu.learn.webdesktop.domain.User;

public interface UserService {

	User findByUserName(String username);
	void addUser (User user);
}
