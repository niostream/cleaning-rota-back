package com.example.dto.cleaningRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistRecordUserDto {
	
	/** ユーザーID */
	private String userId;
	
	/** 権限フラグ */
	private Integer adminFlag;
	
	/** 寮ID */
	private Integer dormitoryId;

}
