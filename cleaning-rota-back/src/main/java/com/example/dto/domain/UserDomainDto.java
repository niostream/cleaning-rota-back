package com.example.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDomainDto {
	
	/** ユーザーID */
	private String userId;
	
	/** 削除フラグ */
	private Integer deleteFlag;
	
	/** パスワード */
	private String password;
	
	/** 名 */
	private String firstName;
	
	/** 姓 */
	private String lastName;
	
}
