package com.comakeit.mrbs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.mrbs.entity.Login;
import com.comakeit.mrbs.entity.MeetingRoom;
import com.comakeit.mrbs.entity.Resource;
import com.comakeit.mrbs.exception.MRBSUnAuthorizedException;

@Controller
public class LoginController {
	@Autowired
	private Environment environment;

	@RequestMapping("/Login")
	@PostMapping
	ModelAndView authenticate(HttpServletRequest request, Model model) throws Exception {
		String portNumebr = environment.getProperty("server.port");
		String baseURL = "http://localhost:" + portNumebr + "/";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RestTemplate restTemplate = new RestTemplate();
		Login user = new Login();
		user.setUsername(username);
		user.setPassword(password);
		
		HttpSession session = request.getSession();
		String resourceListURL = "user/getResourceList";
		String meetingRoomListURL = "user/getMeetingRoomList";
		
		try {
			user = restTemplate.postForObject(baseURL + "login/login", user, Login.class);
		}catch (Exception mrbsUnAuthorizedException) {
			return new ModelAndView("redirect:index.jsp?operation=error");	
		}
		ResponseEntity<ArrayList<MeetingRoom>> meetingRoomListRespose = restTemplate.exchange(
				baseURL + meetingRoomListURL, HttpMethod.GET, null,
				new ParameterizedTypeReference<ArrayList<MeetingRoom>>() {
				});
		ArrayList<MeetingRoom> meetingRoomList = meetingRoomListRespose.getBody();
		
		ResponseEntity<ArrayList<Resource>> resourceListRespose = restTemplate.exchange(baseURL + resourceListURL,
				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Resource>>() {
				});

		ArrayList<Resource> resourceList = resourceListRespose.getBody();
		session.setAttribute("meetingRoomList", meetingRoomList);
		session.setAttribute("resourceList", resourceList);
		
			session.setAttribute("user", user);
			if (user.getRole().equals("FM")) {
				return new ModelAndView("forward:FacilityManager.jsp");
			} else if (user.getRole().equals("user")) {
				return new ModelAndView("forward:" + "User.jsp");
				
			}
		return new ModelAndView("redirect:index.jsp?operation=error"); 

	}
}
