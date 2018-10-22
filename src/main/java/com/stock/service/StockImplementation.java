package com.stock.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.StockWatchlist;
import com.stock.dao.User;
 
import com.stock.restGetDao.StockDao;
import com.stock.thread.watchlist.WatchlistDao;

import pl.zankowski.iextrading4j.api.stocks.Quote;

@Service
public class StockImplementation implements StockService {

 
	@Autowired
	private StockDao stockDao;
	
	
	@Autowired
	private WatchlistDao watchlistDao;
	

/*	@Autowired
	private AuthenticatorClass authenticate;
	*/
	@Override
	@Transactional
	public List<com.stock.dao.StockIndex> getQuotes() {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------------------------------------");
		return stockDao.getQuotes();
	}

	@Override
	@Transactional
	public com.stock.dao.StockIndex getQuote(String ticker) {
		// TODO Auto-generated method stub
		return stockDao.getQuote(ticker);
	}

	@Override
	public Quote getQuoteDetails(String ticker) {
		return stockDao.getQuoteDetails(ticker);
	}

	@Override
	public  List<com.stock.dao.StockWatchlist> createQuoteWatchlist(String ticker) {
	
		return stockDao.createQuoteWatchlist(ticker);
	}


	@Override
	public List<StockWatchlist> createQuoteWatchlist() {

		return stockDao.createQuoteWatchlist();
	}
	
	
	
	
}
