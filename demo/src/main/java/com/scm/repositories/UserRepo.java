package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // Custom query methods (if any) can be added here
	//custom query
	//custom finder method
	
	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email,String password);
}
