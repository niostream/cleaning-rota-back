package com.example.dto.cleaningRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistRecordDto {
	
	/** 掃除当番アイテム */
	private String item;
	
	/** ユーザー */
	private String user;

}
