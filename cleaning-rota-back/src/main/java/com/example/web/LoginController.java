package com.example.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.dto.login.LoginDto;
import com.example.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
		
	@GetMapping
	public User getLoginUser(@ModelAttribute LoginDto loginDto) throws Exception {
		Optional<User> user = loginService.getUserByUserId(loginDto.getUserId());
		if (user.isPresent()
				&& passwordEncoder.matches(loginDto.getPassword(), user.get().getPassword())) {
			return user.get();
		} else {
			throw new Exception();
		}
	}
	
}
