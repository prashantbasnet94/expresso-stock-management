package com.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.Stock;
import com.stock.restController.StockDao;

import pl.zankowski.iextrading4j.api.stocks.Quote;

@Service
public class StockImplementation implements StockService {

	@Autowired
	private StockDao stockDao;
	
	@Override
	@Transactional
	public List<Stock> getQuotes() {
		// TODO Auto-generated method stub
		return stockDao.getQuotes();
	}

	@Override
	@Transactional
	public Stock getQuote(String ticker) {
		// TODO Auto-generated method stub
		return stockDao.getQuote(ticker);
	}

	@Override
	public Quote getQuoteDetails(String ticker) {
		return stockDao.getQuoteDetails(ticker);
	}
}
