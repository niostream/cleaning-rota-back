package com.example.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.domain.CleaningRecord;
import com.example.rowmapper.CleaningRecordRowMapper;
import com.example.sql.CleaningRecordSql;

@Service
public class CleaningRecordService {
		
	@Autowired
	NamedParameterJdbcTemplate template;
	
	@Autowired
	CleaningRecordSql cleaningRecordSql;
	
	@Autowired
	CleaningRecordRowMapper cleaningRecordRowMapper;
	
	/**
	 * 主キーソート掃除当番表レコード全検索
	 * @return
	 */
	public List<CleaningRecord> findAllOrderByRecordId() {
		List<CleaningRecord> records = template.query(
				cleaningRecordSql.getFindAllOrderByRecordId(),
				cleaningRecordRowMapper.getCleaningRecordRowMapper());
		return records;
	}
	
	/**
	 * 主キーソート日付条件掃除当番表レコード全検索
	 * @param fromDate 検索開始日
	 * @param toDate 検索終了日
	 * @return
	 */
	public List<CleaningRecord> findAllByExecutedDateOrderByRecordId(LocalDate fromDate, LocalDate toDate) {
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		
		List<CleaningRecord> records = template.query(
				cleaningRecordSql.getFindAllByExecutedDateOrderByRecordId(), parameters,
				cleaningRecordRowMapper.getCleaningRecordRowMapper());
		return records;
		
	}

}
