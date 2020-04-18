package com.example.dto.vuex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	/** ユーザーID */
	private String userId;
	
	/** パスワード */
	private String password;

}
