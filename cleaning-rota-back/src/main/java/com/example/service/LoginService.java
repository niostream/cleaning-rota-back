package com.example.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.rowmapper.UserRowMapper;
import com.example.sql.UserSql;

@Service
public class LoginService {
	
	@Autowired
	NamedParameterJdbcTemplate template;
	
	@Autowired
	UserSql userSql;
	
	@Autowired
	UserRowMapper userRowMapper;

	public Optional<User> getUserByUserId(String userId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userId", userId);
		return Optional.ofNullable(template.query(userSql.getUserByUserId(), parameters,
				userRowMapper.getUserResultSetExtractor()));	
	}

}
