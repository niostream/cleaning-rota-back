package com.example.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.domain.CleaningRecord;
import com.example.domain.Item;
import com.example.dto.cleaningRecord.RegistRecordItemDto;
import com.example.dto.cleaningRecord.RegistRecordUserDto;
import com.example.dto.cleaningRecord.ShowRecordDto;
import com.example.rowmapper.CleaningRecordRowMapper;
import com.example.rowmapper.ItemRowMapper;
import com.example.sql.CleaningRecordSql;
import com.example.sql.ItemSql;

@Service
public class CleaningRecordService {
		
	@Autowired
	NamedParameterJdbcTemplate template;
	
	@Autowired
	ItemSql itemSql;
	
	@Autowired
	CleaningRecordSql cleaningRecordSql;
	
	@Autowired
	ItemRowMapper itemRowMapper;
	
	@Autowired
	CleaningRecordRowMapper cleaningRecordRowMapper;
	
	/**
	 * 主キーソートアイテム全検索
	 * @return
	 */
	public List<Item> findAllItemOrderByItemId() {
		List<Item> records = template.query(itemSql.getItemOrderByItemId(),
				itemRowMapper.getItemRowMapper());
		return records;
	}
	
	/**
	 * 実行日ソート実行日条件掃除当番表レコード全検索
	 * @param ShowRecordDto 掃除当番表DTO
	 * @return
	 */
	public List<CleaningRecord> findAllByExecutedDateOrderByExecutedDate(ShowRecordDto showRecordDto) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dormitoryId", showRecordDto.getDormitoryId());
		parameters.put("yearMonth",
				String.valueOf(showRecordDto.getExecutedDate().getYear())
				+ String.format("%02d", showRecordDto.getExecutedDate().getMonthValue()));
		parameters.put("deleteFlag", 0);
		return template.query(
				cleaningRecordSql.getFindAllByExecutedDateOrderByExecutedDate(), parameters,
				cleaningRecordRowMapper.getCleaningRecordRowMapper());
	}
	
	/**
	 * 掃除当番表レコード登録
	 * @param registRecordItemDto 掃除アイテム
	 * @param registRecordUserDto ユーザー
	 * @return
	 */
	public Integer registCleaningRecord(RegistRecordItemDto registRecordItemDto,
			RegistRecordUserDto registRecordUserDto) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("executedDate", registRecordItemDto.getExecutedDate());
		parameters.put("itemId", registRecordItemDto.getItem().getItemId());
		parameters.put("userId", registRecordUserDto.getUserId());
		parameters.put("dormitoryId", registRecordUserDto.getDormitoryId());
		parameters.put("deleteFlag", 0);
		return template.update(cleaningRecordSql.registCleaningRecord(), parameters);
	}
	
	/**
	 * 掃除当番表レコード取り消し
	 * @param registRecordItemDto 掃除アイテム
	 * @param registRecordUserDto ユーザー
	 * @return
	 */
	public Integer cancelCleaningRecord(RegistRecordItemDto registRecordItemDto,
			RegistRecordUserDto registRecordUserDto) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("executedDate", registRecordItemDto.getExecutedDate());
		parameters.put("itemId", registRecordItemDto.getItem().getItemId());
		parameters.put("userId", registRecordUserDto.getUserId());
		parameters.put("dormitoryId", registRecordUserDto.getDormitoryId());
		parameters.put("deleteFlag", 1);
		return template.update(cleaningRecordSql.cancelCleaningRecord(), parameters);
	}
		
	/**
	 * 主キーソート日付条件掃除当番表レコード全検索(Try版)
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
