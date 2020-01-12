package com.example.sql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserSql {
	
	/**
	 * ユーザーID条件ユーザー検索SQL
	 * @return
	 */
	@Bean
	public String getUserByUserId() {
		StringBuilder sql = new StringBuilder();
		sql.append("where ")
			.append("user.user_id = :userId ");
		return getFindAllColumn() + sql.toString();
	}
	
	/**
	 * ユーザーID条件ユーザー更新SQL
	 * @return
	 */
	@Bean
	public String updatePasswordByUserId() {
		StringBuilder sql = new StringBuilder();
		sql.append("where ")
			.append("user.user_id = :userId ");
		return getUpdatePasswordColumn() + sql.toString();
	}
	
	/**
	 * ユーザー全取得カラム
	 * @return
	 */
	private final String getFindAllColumn() {
		StringBuilder sql = new StringBuilder();
		sql.append("select ")
			.append("user.user_id, ")
			.append("user.delete_flag, ")
			.append("user.password, ")
			.append("user.first_name, ")
			.append("user.last_name, ")
			.append("config_admin.admin_flag, ")
			.append("config_admin.admin_name, ")
			.append("dormitory.dormitory_id, ")
			.append("dormitory.delete_flag, ")
			.append("dormitory.dormitory_postal_code, ")
			.append("dormitory.dormitory_prefecture, ")
			.append("dormitory.dormitory_city, ")
			.append("dormitory.dormitory_town, ")
			.append("dormitory.dormitory_block, ")
			.append("dormitory.dormitory_detail, ")
			.append("dormitory.dormitory_name ")
			.append("from ")
			.append("users user ")
			.append("inner join config_admin config_admin ")
			.append("on user.admin_flag = config_admin.admin_flag ")
			.append("inner join dormitories dormitory ")
			.append("on user.dormitory_id = dormitory.dormitory_id ");
		return sql.toString();
	}
	
	/**
	 * パスワード更新カラム
	 * @return
	 */
	private final String getUpdatePasswordColumn() {
		StringBuilder sql = new StringBuilder();
		sql.append("update ")
			.append("users user ")
			.append("set ")
			.append("user.password = :password ");
		return sql.toString();
	}
	
}
