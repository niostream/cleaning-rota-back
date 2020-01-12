package com.example.sql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemSql {
	
	/**
	 * 主キーソートアイテム全取得SQL
	 * @return
	 */
	@Bean
	public String getItemOrderByItemId() {
		StringBuilder sql = new StringBuilder();
		sql.append("order by ")
			.append("item.item_id ");
		return getFindAllColumn() + sql.toString();
	}
		
	/**
	 * アイテム全取得カラム
	 * @return
	 */
	private final String getFindAllColumn() {
		StringBuilder sql = new StringBuilder();
		sql.append("select ")
			.append("item.item_id, ")
			.append("item.delete_flag, ")
			.append("item.item_name, ")
			.append("item.item_value ")
			.append("from ")
			.append("items item ");
		return sql.toString();
	}
	
}
