package com.example.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.example.domain.ConfigAdmin;
import com.example.domain.Dormitory;
import com.example.domain.User;

@Configuration
public class UserRowMapper {
	
	@Bean
	public ResultSetExtractor<User> getUserResultSetExtractor() {
		return new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (!rs.next()) return null;
				
				User user = new User();
				ConfigAdmin configAdmin = new ConfigAdmin();
				Dormitory dormitory = new Dormitory();
				
				user.setUserId(rs.getString("user.user_id"));
				user.setDeleteFlag(rs.getInt("user.delete_flag"));
				user.setPassword(rs.getString("user.password"));
				user.setFirstName(rs.getString("user.first_name"));
				user.setLastName(rs.getString("user.last_name"));
				configAdmin.setAdminFlag(rs.getInt("config_admin.admin_flag"));
				configAdmin.setAdminName(rs.getString("config_admin.admin_name"));
				dormitory.setDormitoryId(rs.getInt("dormitory.dormitory_id"));
				dormitory.setDormitoryName(rs.getString("dormitory.dormitory_name"));
				
				user.setConfigAdmin(configAdmin);
				user.setDormitory(dormitory);
				
				return user;
			}	
		};
	}
	
	@Bean
	public RowMapper<User> getUserRowMapper() {
		return new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (!rs.next()) return null;
				
				User user = new User();
				ConfigAdmin configAdmin = new ConfigAdmin();
				Dormitory dormitory = new Dormitory();
				
				user.setUserId(rs.getString("user.user_id"));
				user.setDeleteFlag(rs.getInt("user.delete_flag"));
				user.setPassword(rs.getString("user.password"));
				user.setFirstName(rs.getString("user.first_name"));
				user.setLastName(rs.getString("user.last_name"));
				configAdmin.setAdminFlag(rs.getInt("config_admin.admin_flag"));
				configAdmin.setAdminName(rs.getString("config_admin.admin_name"));
				dormitory.setDormitoryId(rs.getInt("dormitory.dormitory_id"));
				dormitory.setDormitoryName(rs.getString("dormitory.dormitory_name"));
				
				user.setConfigAdmin(configAdmin);
				user.setDormitory(dormitory);
				
				return user;
			}
        };
	}

}
