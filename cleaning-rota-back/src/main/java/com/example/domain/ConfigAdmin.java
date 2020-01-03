package com.example.domain;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("config_admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigAdmin {
	
	/** 権限フラグ */
	private Integer adminFlag;
	
	/** 権限名 */
	private String adminName;
	
}
