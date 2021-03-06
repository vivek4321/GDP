package com.GDP.test.service;

import java.util.List;

import com.GDP.test.model.User;

public interface UserService {

	
	public void registerAnUser(User newuser);
	public User signInCheck(String userName);
	public List<User> getAllUsers();
	public String passwordRecovery(String email);
	public boolean existingUserCheck(String email);
	public void passwordReset(User user);
	public void verifyUser(String email, String token);
}
