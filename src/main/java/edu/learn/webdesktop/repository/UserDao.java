package edu.learn.webdesktop.repository;

import edu.learn.webdesktop.domain.User;


public interface UserDao {

	User findByUserName(String username);
	void addUser(User user);
}