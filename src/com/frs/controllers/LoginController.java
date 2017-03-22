package com.frs.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frs.pojos.Flight;
import com.frs.pojos.UserCredential;
import com.frs.pojos.UserProfile;
import com.frs.service.AdministratorService;
import com.frs.service.LoginService;

@Controller
// mandatory
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	private LoginService service;


	public LoginController() {
		System.out.println("in controllr constr ");
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		System.out.println("in init");
	}

	// controller method to display reg form
	@RequestMapping(value = "/login")
	public String showLoginForm(UserCredential userCredential) {
		System.out.println("in show login form " );

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(UserCredential userCredential,Model map, HttpSession hs) {
		System.out.println("in process login");
		System.out.println("userCredential " + userCredential);
		// invoke service layer method
		UserCredential userDetails = service.login(userCredential.getEmailid(),userCredential.getPassword());
		System.out.println("User Details"+userDetails);
		if (userDetails == null) {
			map.addAttribute("mesg", "Username or password is Wrong , Pls retry!!!!!!");
			return "login";
		}
		if(userDetails.getUsertype().equals("A"))
		{
			return "Admin";
		}
		else if(userDetails.getUsertype().equals("C"))
		{
			//hs.setAttribute("userCredential", userDetails);
			
			hs.setAttribute("userid",userDetails.getUserid());
			hs.setAttribute("status", "log in Successful");
			return "user";
		}
		return "login";
	}

	@RequestMapping(value = "/register")
	public String showRegForm(UserProfile userProfile) {
		System.out.println("in show reg form " );

		return "register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegForm(UserProfile userProfile,Model map, HttpSession hs) {
		System.out.println("in process login");
		System.out.println("userCredential " + userProfile);

		UserCredential u=new UserCredential();
		u.setEmailid(userProfile.getEmailid());
		u.setPassword(userProfile.getPassword());
		u.setUsertype("C");
		u.setLoginstatus(0);
		// invoke service layer method
		UserProfile userDetails = service.register(userProfile,u);
		System.out.println("User Details"+userDetails);
		if (userDetails == null) {
			map.addAttribute("mesg", "Username or password is Wrong , Pls retry!!!!!!");
			return "register";
		}
		hs.setAttribute("userCredential", userDetails);
		hs.setAttribute("status", "log in Successful");
		return "login";// replace forward by redirect
	}



}
