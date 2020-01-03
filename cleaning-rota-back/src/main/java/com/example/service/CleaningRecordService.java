package com.example.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.domain.CleaningRecord;
import com.example.domain.ConfigAdmin;
import com.example.domain.Dormitory;
import com.example.domain.Item;
import com.example.domain.User;
import com.example.sql.CleaningRecordSql;

@Service
public class CleaningRecordService {
		
	@Autowired
	NamedParameterJdbcTemplate template;
	
	@Autowired
	CleaningRecordSql cleaningRecordSql;
	
	/**
	 * 主キーソート掃除当番表レコード全検索
	 * @return
	 */
	public List<CleaningRecord> findAllOrderByRecordId() {
		
		List<CleaningRecord> records = template.query(cleaningRecordSql.getFindAllOrderByRecordId(), (rs, rowNum) -> {
			CleaningRecord cr = new CleaningRecord();
			Item item = new Item();
			User user = new User();
			ConfigAdmin configAdmin = new ConfigAdmin();
			Dormitory dormitory = new Dormitory();
			
			cr.setRecordId(rs.getInt("cr.record_id"));
			cr.setDeleteFlag(rs.getInt("cr.delete_flag"));
			cr.setExecutedDate(LocalDate.parse(rs.getString("executed_date")));
			item.setItemId(rs.getInt("item.item_id"));
			item.setItemName(rs.getString("item.item_name"));
			item.setDeleteFlag(rs.getInt("item.delete_flag"));
			user.setUserId("user.user_id");
			user.setDeleteFlag(rs.getInt("user.delete_flag"));
			user.setPassword(rs.getString("user.user_id"));
			user.setFirstName(rs.getString("user.first_name"));
			user.setLastName(rs.getString("user.last_name"));
			configAdmin.setAdminFlag(rs.getInt("config_admin.admin_flag"));
			configAdmin.setAdminName(rs.getString("config_admin.admin_name"));
			user.setConfigAdmin(configAdmin);
			dormitory.setDormitoryId(rs.getInt("dormitory.dormitory_id"));
			dormitory.setDormitoryName(rs.getString("dormitory.dormitory_name"));
			
			cr.setItem(item);
			cr.setUser(user);
			cr.setDormitory(dormitory);
			
			return cr;
		});
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
		
		List<CleaningRecord> records = template.query(cleaningRecordSql.getFindAllByExecutedDateOrderByRecordId(), parameters, (rs, rowNum) -> {
			CleaningRecord cr = new CleaningRecord();
			Item item = new Item();
			User user = new User();
			ConfigAdmin configAdmin = new ConfigAdmin();
			Dormitory dormitory = new Dormitory();
			
			cr.setRecordId(rs.getInt("cr.record_id"));
			cr.setDeleteFlag(rs.getInt("cr.delete_flag"));
			cr.setExecutedDate(LocalDate.parse(rs.getString("executed_date")));
			item.setItemId(rs.getInt("item.item_id"));
			item.setItemName(rs.getString("item.item_name"));
			item.setDeleteFlag(rs.getInt("item.delete_flag"));
			user.setUserId("user.user_id");
			user.setDeleteFlag(rs.getInt("user.delete_flag"));
			user.setPassword(rs.getString("user.user_id"));
			user.setFirstName(rs.getString("user.first_name"));
			user.setLastName(rs.getString("user.last_name"));
			configAdmin.setAdminFlag(rs.getInt("config_admin.admin_flag"));
			configAdmin.setAdminName(rs.getString("config_admin.admin_name"));
			user.setConfigAdmin(configAdmin);
			dormitory.setDormitoryId(rs.getInt("dormitory.dormitory_id"));
			dormitory.setDormitoryName(rs.getString("dormitory.dormitory_name"));
			
			cr.setItem(item);
			cr.setUser(user);
			cr.setDormitory(dormitory);
			
			return cr;
		});
		return records;
		
	}

}
