package com.scm.services.implimetation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.entity.User;
import com.scm.repositories.UserRepo;
import com.scm.services.UserServices;
import com.scm.helper.*;

@Service
public class UserServiceImpl implements UserServices
{
	
	@Autowired
	private UserRepo userRepo;
	

	private Logger logger= org.slf4j.LoggerFactory.getLogger(this.getClass());	


	@Override
	public User saveUser(User user) {
		//user id have to generate 
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);

		//password encode
		//user.setPassword(userId)
		
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserById(String id) {
		
		return userRepo.findById(id);
	}

	@Override
	public Optional<User> updateUser(User user) {
		
	User user2=	userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("User Not found"));
		
	//Update karange to user2
	user2.setName(user.getName());
	user2.setEmail(user.getEmail());
	user2.setPassword(user.getPassword());
	user2.setAbout(user.getAbout());
  user2.setPhoneNumber(user.getPhoneNumber());	
  user2.setProfilePic(user.getProfilePic());
  user2.setEnabled(user.isEnabled());
  user2.setEamilVerified(user.isEamilVerified());
  user2.setPhoneVerifies(user.isPhoneVerifies());
  user2.setProvider(user.getProvider());
  user2.setProviderUserId(user.getProviderUserId());

  //Save in the Database
  
  User save=userRepo.save(user2);
  return Optional.ofNullable(save);
	
	
	}

	@Override
	public void deleteuser(String id) {
		User user2=	userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not found"));
           userRepo.delete(user2);
		
	}

	@Override
	public boolean isUserExit(String UserId) {
		
		User user2=	userRepo.findById(UserId).orElse(null);

		return user2 != null ? true : false;
	}

	@Override
	public boolean isUserExitByEmail(String email) {
	User user=	userRepo.findByEmail(email).orElse(null);
		
		
		return user != null ? true : false ;
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}
	

	

}
