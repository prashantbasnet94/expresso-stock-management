package com.stock.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dao.Stock;

@RestController
@RequestMapping("stock")
public class ApiRequest {
	
	@Autowired
	private ApiService apiService;
		
	@GetMapping("getQuote")
	public List<Stock> getQuote() {
		System.out.println("hello-----------");
	return apiService.getQuote();
	}
}
