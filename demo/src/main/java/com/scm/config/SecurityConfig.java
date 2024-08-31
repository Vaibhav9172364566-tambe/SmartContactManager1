package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.scm.services.implimetation.SecurityCustomUserDetailsService;

@Configuration
public class SecurityConfig {
	
	//user create and login using java code with in memory service
	//Bean
//	
//	@Bean
//	public UserDetailsService userDetailsService() {
//	UserDetails user1 =	User
//			.withDefaultPasswordEncoder()
//			 .username("admin123")
//			.password("admin123")
//			.roles("ADMIN","USER")
//			.build();
//	
//	UserDetails user2 =	User
//			.withDefaultPasswordEncoder()
//			 .username("user123")
//			.password("user123")
//		//	.roles("ADMIN","USER")
//			.build();
//	var inMemoryUserDetailsManager=	new InMemoryUserDetailsManager(user1,user2);
//		return inMemoryUserDetailsManager;
//	}
	
	@Autowired
	private SecurityCustomUserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		//user detail service  ka object
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		//password incoder are object
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
