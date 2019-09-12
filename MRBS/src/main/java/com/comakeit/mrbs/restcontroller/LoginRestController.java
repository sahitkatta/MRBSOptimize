package com.comakeit.mrbs.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.mrbs.entity.Login;
import com.comakeit.mrbs.exception.MRBSUnAuthorizedException;
import com.comakeit.mrbs.service.LoginService;



@RestController
@RequestMapping("/login")
public class LoginRestController {
	@Autowired
	private LoginService loginService;
	
	
	//POST
	/*
	 * authenticate
	 * */
	
	@RequestMapping("/login")
	@PostMapping
	Login authenticate(@RequestBody Login user) throws Exception {
		user = loginService.authenticate(user);
		if(user == null) {
			throw new MRBSUnAuthorizedException();
		}
		return loginService.authenticate(user);
	}
	
}
