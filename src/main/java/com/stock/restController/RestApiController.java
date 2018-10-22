package com.stock.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dao.StockIndex;
import com.stock.service.StockService;

import pl.zankowski.iextrading4j.api.stocks.Quote;

@RestController
@RequestMapping("stock")
public class RestApiController {
	
	@Autowired
	private StockService stockService;
	
 
		
	@GetMapping("getQuotes")
	public List<StockIndex> getQuotes() {
		System.out.println("hello-----------");
	return stockService.getQuotes();
	}
	
	@GetMapping("getQuote/{id}")
	public StockIndex getQuote(@PathVariable String id) {
		
		return stockService.getQuote(id);
		
	}
	
	@GetMapping("getQuoteDetails/{id}")
	public Quote getQuoteDetails(@PathVariable String id) {
		
		return stockService.getQuoteDetails(id);
		
	}
	
	
	@GetMapping("createQuoteWatchlist/{id}")
	public List<com.stock.dao.StockWatchlist> createQuoteWatchlist(@PathVariable String id) {
		
		return stockService.createQuoteWatchlist(id);
	}
	
	@GetMapping("getQuoteWatchlist")
	public List<com.stock.dao.StockWatchlist> createQuoteWatchlist() {
		
		return stockService.createQuoteWatchlist();
	}
}
