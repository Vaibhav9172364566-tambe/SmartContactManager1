package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entity.User;

public interface UserServices {
	
	
	User saveUser(User user);
	
	Optional<User> getUserById(String id);
	
	Optional<User> updateUser(User user);
	
	void deleteuser(String id);
	
	boolean isUserExit(String UserId);
	
	boolean isUserExitByEmail(String email);
	
	List<User> getAllUsers();
	
    //add more method
	
}
