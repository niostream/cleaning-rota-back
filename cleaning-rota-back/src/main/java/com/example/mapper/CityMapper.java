package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.City;

@Mapper
public interface CityMapper {
	
	@Select("SELECT id, name, state, country FROM city WHERE state = #{state}")
    City findByState(@Param("state") String state);

}
