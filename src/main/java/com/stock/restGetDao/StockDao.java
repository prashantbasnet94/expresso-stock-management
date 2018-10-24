package com.stock.restGetDao;

import java.util.List;

import com.stock.dao.StockIndex;
import com.stock.dao.StockWatchlist;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface StockDao {

	List<StockIndex> getQuotes();

	StockIndex getQuote(String ticker);

	Quote getQuoteDetails(String ticker);
	
	List<StockWatchlist> createQuoteWatchlist(String ticker);
 

	List<StockWatchlist> createQuoteWatchlist();
 
}
