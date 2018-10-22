package com.stock.thread.watchlist;

import java.util.List;

import com.stock.dao.StockWatchlist;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface WatchlistDao {

	List<StockWatchlist> createQuoteWatchlist(String ticker);

	List<StockWatchlist> createQuoteWatchlist();

 
	
	 
}
