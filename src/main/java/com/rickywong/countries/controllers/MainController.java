package com.rickywong.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rickywong.countries.models.City;
import com.rickywong.countries.services.ApiService;

@Controller
public class MainController {
	
	private final ApiService ApiService;
	
	@Autowired
	public MainController(ApiService ApiService) {
		this.ApiService = ApiService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {

		List<Object[]> table8 = ApiService.summaryCountriesInRegion();
		for (Object[] row : table8) {
			System.out.println(row[0] + " " + row[1]);
		}
		return "index.jsp";
	}
}
