package com.example.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	
	/** ユーザーID */
	private String userId;
	
	/** パスワード */
	private String password;

}
