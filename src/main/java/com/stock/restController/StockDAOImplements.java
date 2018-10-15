package com.stock.restController;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.stock.dao.Stock;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@Repository
public class StockDAOImplements implements StockDao{
 
	
//starting session
	


	@Override
	public List<Stock> getQuotes() {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Stock.class)
						.buildSessionFactory();
		Session session =factory.getCurrentSession();
		session.beginTransaction();
		
		List<Stock> quote =session.createQuery("from Stock").getResultList();
		
		session.getTransaction().commit();
		
		
		factory.close();
		return quote;
	}

	@Override
	public Stock getQuote(String ticker) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Stock.class)
						.buildSessionFactory();
		
		Session session =factory.getCurrentSession();
		session.beginTransaction();
		
		Stock theStock =session.get(Stock.class, ticker);		
		
		session.getTransaction().commit();
		
		
		factory.close();
		return  theStock;
		
		
		
		
	
		
	}

	

	@Override
	public Quote getQuoteDetails(String ticker) {
		// TODO Auto-generated method stub
		



		final IEXTradingClient iexTradingClient = IEXTradingClient.create();
		
		Quote quote ;
		
		
 
	
		 
		   
		     
		        
					quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
					        .withSymbol(ticker)
					        .build());
			      
		    
		    
	
		
		
	     return quote;
		
		
		
		
	}
}
