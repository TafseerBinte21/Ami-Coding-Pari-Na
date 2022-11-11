package com.tafa.amicodeparina.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tafa.amicodeparina.models.User;
import com.tafa.amicodeparina.controllers.dto.UserRegDto;

public interface UserService extends UserDetailsService{
	User save(UserRegDto registrationDto);
	
	User getUserByEmail(String email);
}
