package com.example.dto.cleaningRecord;

import com.example.dto.domain.ItemDomainDto;
import com.example.dto.domain.UserDomainDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistRecordItemDto {
	
	/** 実行日 */
	private String executedDate;
	
	/** 掃除当番アイテム */
	private ItemDomainDto item;
	
	/** ユーザー */
	private UserDomainDto user;
	
}
