package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("dormitories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dormitory {
	
	/** 寮ID */
	@Id
	private Integer dormitoryId;
	
	/** 削除フラグ */
	private Integer deleteFlag;
	
	/** 寮郵便番号 */
	private String dormitoryPostalCode;
	
	/** 寮住所(県) */
	private String dormitoryPrefecture;
	
	/** 寮住所(市) */
	private String dormitoryCity;
	
	/** 寮住所(町) */
	private String dormitoryTown;
	
	/** 寮住所(番地) */
	private String dormitoryBlock;
	
	/** 寮住所(その他詳細) */
	private String dormitoryDetail;
	
	/** 寮名 */
	private String dormitoryName;
		
}
