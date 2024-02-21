package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UsersService us;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		if (us.emailExists(user.getEmail()) == false) {
			us.addUser(user);
			return "registerSuccess";
		} else {
			return "registerFail";
		}
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam String email,
			@RequestParam String password , HttpSession session, Model model) 
	{
		if (us.validateUser(email, password) == true) {
			session.setAttribute("email", email);
			if (us.findRole(email).equals("admin")) {
				Users user = us.getUser(email);
				model.addAttribute("user", user);
				return "adminhome";
			} else {
				return "customerhome";
			}
		} else {
			return "loginFail";
		}
	}
	
	@GetMapping("/exploreSongs")
	public String exploreSongs( HttpSession session)
	{	
		String email = (String) session.getAttribute("email");
		Users user = us.getUser(email);
		
		boolean userStatus = user.isPremium();
		if(userStatus == true) {
			return "viewCustomerSongs";
		}else {
			return "samplePayment";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

}
