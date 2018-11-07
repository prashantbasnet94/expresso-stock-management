package com.stock.restGetDao;

import java.security.Principal;
import java.util.List;

import com.stock.dao.StockIndex;
import com.stock.dao.StockPortfolio;
import com.stock.dao.StockWatchlist;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface StockDao {

	List<StockIndex> getQuotes();

	StockIndex getQuote(String ticker);

	Quote getQuoteDetails(String ticker);
	
	List<StockWatchlist> createQuoteWatchlist(String ticker,Principal pri);
 

	List<StockWatchlist> getQuoteWatchlist(Principal pri);

	List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri,int quantity,int date);

	List<StockPortfolio> getQuotePortfolio(Principal pri);
 
}
