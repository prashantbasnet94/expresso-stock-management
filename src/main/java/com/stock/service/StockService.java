package com.stock.service;

import java.util.List;

import com.stock.dao.Stock;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface StockService {
	public List<Stock> getQuotes();
	
	public Stock getQuote(String ticker);
	
	Quote getQuoteDetails(String ticker);
	
}
