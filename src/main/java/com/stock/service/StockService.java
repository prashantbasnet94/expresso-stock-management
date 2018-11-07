package com.stock.service;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.stock.dao.StockIndex;
import com.stock.dao.StockPortfolio;
import com.stock.dao.StockWatchlist;
 
import com.stock.dao.User;
 

import pl.zankowski.iextrading4j.api.stocks.Quote;

@Service
public interface StockService {
	public List<StockIndex> getQuotes();
	
	public StockIndex getQuote(String ticker);
	
	Quote getQuoteDetails(String ticker);
	
	List<StockWatchlist> createQuoteWatchlist(String ticker, Principal pri); 

	public List<StockWatchlist> getQuoteWatchlist(Principal pri);

	public List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri, int quantity, int date);

	public List<StockPortfolio> getQuotePortfolio(Principal pri);

}
