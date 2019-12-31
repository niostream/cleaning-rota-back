package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.City;
import com.example.mapper.CityMapper;

@RestController
public class CityController {
	
	@Autowired
    private CityMapper cityMapper;

    @RequestMapping("/")
    public City index() {
        City city1 = cityMapper.findByState("CA");
        System.out.println(city1);
        return city1;
    }

}
