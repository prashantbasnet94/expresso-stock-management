package com.stock.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.stock.dao.StockIndex;
import com.stock.dao.StockWatchlist;
import com.stock.dao.User;

import pl.zankowski.iextrading4j.api.stocks.Quote;

@Service
public interface StockService {
	public List<StockIndex> getQuotes();
	
	public StockIndex getQuote(String ticker);
	
	Quote getQuoteDetails(String ticker);
	
	List<StockWatchlist> createQuoteWatchlist(String ticker);



	public List<StockWatchlist> createQuoteWatchlist();
	
}
