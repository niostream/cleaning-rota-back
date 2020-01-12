package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	/** アイテムID */
	@Id
	private Integer itemId;
	
	/** 削除フラグ */
	private Integer deleteFlag;
	
	/** アイテム名 */
	private String itemName;
	
	/** アイテムバリュー */
	private String itemValue;
	
}
