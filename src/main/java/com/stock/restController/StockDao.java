package com.stock.restController;

import java.util.List;

import com.stock.dao.Stock;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface StockDao {

	List<Stock> getQuotes();

	Stock getQuote(String ticker);

	Quote getQuoteDetails(String ticker);
	
}
