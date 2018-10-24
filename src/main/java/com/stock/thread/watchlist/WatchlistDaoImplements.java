package com.stock.thread.watchlist;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.context.annotation.Bean;
 
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.StockWatchlist;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@Repository
public class WatchlistDaoImplements implements WatchlistDao{

 
	Thread thread1,thread2;
	
 
 
	public List<StockWatchlist> extended(String ticker) {
 
		
		final IEXTradingClient iexTradingClient = IEXTradingClient.create();
		
		Quote quote ;
		quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
					        .withSymbol(ticker)
					        .build());
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockWatchlist.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 
			
				     
					try {
						 
				     
				    	

				
						com.stock.dao.StockWatchlist stock = new 	com.stock.dao.StockWatchlist("username",quote.getCompanyName(), quote.getSymbol(), quote.getLow(), quote.getHigh(), quote.getChangePercent(),
								quote.getLatestVolume(), quote.getMarketCap(), quote.getOpen()) ;
				
			    session.beginTransaction();
			    session.save(stock);
			    session.getTransaction().commit();
			    session.close();
				
		 
			
			
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						factory.close();
					}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//getting fetching data from database
		
		 factory = new Configuration()
				.configure("hibernate.cfg.xml")
					.addAnnotatedClass(com.stock.dao.StockWatchlist.class)
						.buildSessionFactory();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("-----------------------------------------------------");
		List<com.stock.dao.StockWatchlist> watchlistQuote =session.createQuery("from com.stock.dao.StockWatchlist").getResultList();
		System.out.println(watchlistQuote);
		System.out.println("*******************************************************");
		
		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return watchlistQuote;
 
	}


 



	@Override
	public List<StockWatchlist> createQuoteWatchlist() {
		 
		return extended();
	}



	private List<StockWatchlist> extended() {
		// TODO Auto-generated method stub
		
		
		//getting fetching data from database
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockWatchlist.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("-----------------------------------------------------");
		List<com.stock.dao.StockWatchlist> watchlistQuote =session.createQuery("from com.stock.dao.StockWatchlist").getResultList();
		System.out.println(watchlistQuote);
		System.out.println("*******************************************************");
		
		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return watchlistQuote;
		
	}
 



	@Override
	public List<StockWatchlist> createQuoteWatchlist(String ticker) {
		
		// TODO Auto-generated method stub
		
			 
				//SaveToDatabase saveToDatabase = new SaveToDatabase(ticker);
			//	thread1 = new Thread(saveToDatabase);
			//	thread1.start();
				
				
				
				return extended(ticker);
				
	}
 
	 

}
 
	
	
	