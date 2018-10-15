package com.stock.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dao.Stock;
import com.stock.service.StockService;

import pl.zankowski.iextrading4j.api.stocks.Quote;

@RestController
@RequestMapping("stock")
public class ApiRequest {
	
	@Autowired
	private StockService stockService;
		
	@GetMapping("getQuotes")
	public List<Stock> getQuotes() {
		System.out.println("hello-----------");
	return stockService.getQuotes();
	}
	
	@GetMapping("getQuote/{id}")
	public Stock getQuote(@PathVariable String id) {
		
		return stockService.getQuote(id);
		
	}
	
	@GetMapping("getQuoteDetails/{id}")
	public Quote getQuoteDetails(@PathVariable String id) {
		
		return stockService.getQuoteDetails(id);
		
	}
}
