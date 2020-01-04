package com.example.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.example.domain.CleaningRecord;
import com.example.domain.ConfigAdmin;
import com.example.domain.Dormitory;
import com.example.domain.Item;
import com.example.domain.User;

@Configuration
public class CleaningRecordRowMapper {
	
	@Bean
	public ResultSetExtractor<CleaningRecord> getCleaningRecordResultSetExtractor() {
		return new ResultSetExtractor<CleaningRecord>() {
			@Override
			public CleaningRecord extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (!rs.next()) return null;
				
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
				user.setUserId(rs.getString("user.user_id"));
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
			}	
		};
	}
	
	@Bean
	public RowMapper<CleaningRecord> getCleaningRecordRowMapper() {
		return new RowMapper<CleaningRecord>() {
			@Override
			public CleaningRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.next()) return null;
				
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
				user.setUserId(rs.getString("user.user_id"));
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
			}
        };
	}

}
