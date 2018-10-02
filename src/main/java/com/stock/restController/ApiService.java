package com.stock.restController;

import java.util.List;

import com.stock.dao.Stock;

public interface ApiService {

	List<Stock> getQuote();

	
}
