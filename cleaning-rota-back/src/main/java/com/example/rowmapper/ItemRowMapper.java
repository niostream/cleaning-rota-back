package com.example.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.example.domain.Item;

@Configuration
public class ItemRowMapper {
	
	@Bean
	public ResultSetExtractor<Item> getItemResultSetExtractor() {
		return new ResultSetExtractor<Item>() {
			@Override
			public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (!rs.next()) return null;
				
				Item item = new Item();
				
				item.setItemId(rs.getInt("item.item_id"));
				item.setDeleteFlag(rs.getInt("item.delete_flag"));
				item.setItemName(rs.getString("item.item_name"));
				item.setItemValue(rs.getString("item.item_value"));
								
				return item;
			}	
		};
	}
	
	@Bean
	public RowMapper<Item> getItemRowMapper() {
		return new RowMapper<Item>() {
			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {				
				Item item = new Item();
				
				item.setItemId(rs.getInt("item.item_id"));
				item.setDeleteFlag(rs.getInt("item.delete_flag"));
				item.setItemName(rs.getString("item.item_name"));
				item.setItemValue(rs.getString("item.item_value"));
								
				return item;
			}
        };
	}

}
