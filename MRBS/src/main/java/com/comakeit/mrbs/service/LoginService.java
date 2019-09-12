package com.comakeit.mrbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.mrbs.entity.Login;
import com.comakeit.mrbs.repository.LoginRepository;


@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	
	public Login authenticate(Login user) {
		return loginRepository.authenticate(user.getUsername(), user.getPassword());
	}
}
