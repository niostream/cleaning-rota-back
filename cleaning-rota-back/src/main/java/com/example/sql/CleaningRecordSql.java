package com.example.sql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CleaningRecordSql {
	
	/**
	 * 主キーソート掃除当番表レコード全検索
	 * @return
	 */
	@Bean
	public String getFindAllOrderByRecordId() {
		return getFindAllColumn() + getOrderByRecordId();
	}
	
	/**
	 * 主キーソート日付条件掃除当番表レコード全検索
	 * @return
	 */
	@Bean
	public String getFindAllByExecutedDateOrderByRecordId() {
		StringBuilder sql = new StringBuilder();
		sql.append("where ")
			.append("cr.executed_date ")
			.append("between :fromDate and :toDate ");
		return getFindAllColumn() + sql.toString() + getOrderByRecordId();
	}
	
	/**
	 * 掃除当番表全カラム
	 * @return
	 */
	private final String getFindAllColumn() {
		StringBuilder sql = new StringBuilder();
		sql.append("select ")
			.append("cr.record_id, ")
			.append("cr.delete_flag, ")
			.append("cr.executed_date, ")
			.append("item.item_id, ")
			.append("item.delete_flag, ")
			.append("item.item_name, ")
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
			.append("cleaning_records cr ")
			.append("inner join items item ")
			.append("on cr.item_id = item.item_id ")
			.append("inner join users user ")
			.append("on cr.user_id = user.user_id ")
			.append("inner join config_admin config_admin ")
			.append("on user.admin_flag = config_admin.admin_flag ")
			.append("inner join dormitories dormitory ")
			.append("on cr.dormitory_id = dormitory.dormitory_id ");
		return sql.toString();
	}
	
	/**
	 * 主キーソート
	 * @return
	 */
	private final String getOrderByRecordId() {
		StringBuilder sql = new StringBuilder();
		sql.append("order by cr.record_id ");
		return sql.toString();
	}

}
