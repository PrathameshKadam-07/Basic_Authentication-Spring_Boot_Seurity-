package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.UserBean;
import com.repository.userRepo;

@Service
public class userService implements UserDetailsService {

	@Autowired
	userRepo userRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String username){
		UserBean ub = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
		
		return ub;
	}

}
