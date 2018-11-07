package com.stock.restController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	//setting value in database for watchlist
	@GetMapping("createQuoteWatchlist/{id}")
	public List<com.stock.dao.StockWatchlist> createQuoteWatchlist(@PathVariable String id,Principal pri) {
		
		
		
		return stockService.createQuoteWatchlist(id,pri);
		
	}
	//getting value from database for watchlist
	@GetMapping("getQuoteWatchlist")
	public List<com.stock.dao.StockWatchlist> getQuoteWatchlist(Principal pri) {
 
 
		return stockService.getQuoteWatchlist(pri);
	}
	
/* portfolio */
	
	//setting value in database for Portfolio
		@GetMapping("createQuotePortfolio/{id}")
		public List<com.stock.dao.StockPortfolio> createQuotePortfolio(@PathVariable String id,Principal pri,int quantity,int date) {
			
			
			
			
			return stockService.createQuotePortfolio(id,pri,quantity,date);
			
		}
		//getting value from database for portfolio
		@GetMapping("getQuotePortfolio")
		public List<com.stock.dao.StockPortfolio> getQuotePortfolio(Principal pri) {
	 
	 
			return stockService.getQuotePortfolio(pri);
		}
		
	
	
}
