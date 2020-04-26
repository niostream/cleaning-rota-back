package com.example.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDomainDto {
	
	/** アイテムID */
	private Integer itemId;
	
	/** 削除フラグ */
	private Integer deleteFlag;
	
	/** アイテム名 */
	private String itemName;
	
	/** アイテムバリュー */
	private String itemValue;

}
