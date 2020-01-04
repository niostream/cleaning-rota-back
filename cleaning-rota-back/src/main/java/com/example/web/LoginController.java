package com.example.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping
	public User getLoginUser(@RequestParam("userId") String userId,
			@RequestParam("password") String password) throws Exception {
		Optional<User> user = loginService.getUserByUserId(userId);
		if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
			return user.get();
		} else {
			throw new Exception();
		}
	}

}
