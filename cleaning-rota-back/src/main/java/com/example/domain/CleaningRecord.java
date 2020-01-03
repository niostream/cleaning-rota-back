package com.example.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("cleaning_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleaningRecord {
	
	/** レコードID */
	@Id
	private Integer recordId;
	
	/** 削除フラグ */
	private Integer deleteFlag;
	
	/** 実行日 */
	private LocalDate executedDate;
	
	/** アイテム */
	private Item item;
	
	/** ユーザー */
	private User user;
	
	/** 寮 */
	private Dormitory Dormitory;

}
