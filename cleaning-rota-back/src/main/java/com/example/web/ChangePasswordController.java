package com.example.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.ChangePasswordService;
import com.example.service.LoginService;

@RestController
@RequestMapping("/change-password")
public class ChangePasswordController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ChangePasswordService changePasswordService;
	
	// TODO: Postメソッドに変更する必要があるが、SpringSecurityの関係上エラーになる。
	@GetMapping("/update")
	public int changePassword(@RequestParam("userId") String userId,
			@RequestParam("defaultPassword") String defaultPassword,
			@RequestParam("changePassword") String changePassword) throws Exception {
		
		// ユーザー取得
		Optional<User> user = loginService.getUserByUserId(userId);
		if (!user.isPresent() || !passwordEncoder.matches(defaultPassword, user.get().getPassword())) {
			throw new Exception();
		}
		
		// パスワードエンコード
		user.get().setPassword(passwordEncoder.encode(changePassword));
		
		// ユーザー更新
		return changePasswordService.updatePasswordByUserId(user.get());
		
	}

}
