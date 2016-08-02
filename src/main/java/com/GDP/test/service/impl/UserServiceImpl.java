package com.GDP.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.GDP.test.dao.UserDAO;
import com.GDP.test.model.User;
import com.GDP.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	UserDAO userdaoimpl;
	
	public void setUserdaoimpl(UserDAO userdaoimpl) {
		this.userdaoimpl = userdaoimpl;
	}


//*********************************  IMPLEMENTED METHODS    *********************************

	@Override
	public void registerAnUser(User newuser) {		
		userdaoimpl.registerAnUser(newuser);       
	}




	@Override
	public User signInCheck(String userName) {		
		return userdaoimpl.signInCheck(userName);
	}


	@Override
	public List<User> getAllUsers() {
		return userdaoimpl.getAllUsers();
	}


	@Override
	public String passwordRecovery(String email) {
		// TODO Auto-generated method stub
		return userdaoimpl.passwordRecovery(email);
	}


	@Override
	public void passwordReset(User user) {
		userdaoimpl.passwordReset(user);		
	}


	@Override
	public void verifyUser(String email, String token) {
		userdaoimpl.verifyUser(email, token);
	}


	@Override
	public boolean existingUserCheck(String email) {		
		return userdaoimpl.existingUserCheck(email);
	}



}
