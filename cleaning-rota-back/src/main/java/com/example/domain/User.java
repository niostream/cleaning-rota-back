package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	/** ユーザーID */
	@Id
	private String userId;
	
	/** 削除フラグ */
	private Integer deleteFlag;
	
	/** パスワード */
	private String password;
	
	/** 名字 */
	private String firstName;
	
	/** 名前 */
	private String lastName;
		
	/** 権限設定 */
	private ConfigAdmin configAdmin;
	
	/** 寮 */
	private Dormitory dormitory;
		
}
