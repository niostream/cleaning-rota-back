package com.example.dto.cleaningRecord;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowRecordDto {
	
	/** 寮ID */
	private Integer dormitoryId;
	
	/** 実行日 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate executedDate;

}
