package com.stock.thread.portfolio;

import java.security.Principal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.stock.dao.StockPortfolio;
 

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@Repository
public class PortfolioDaoImplements implements PortfolioDao{
	
	
public static   String  username;
 public static void username(Principal principal) {
	 username = principal.getName();
 }
	
 
 
	public List<StockPortfolio> extended(String ticker, Principal pri, int quantity, int date) {
		
	 //savves data in the db
 
		
		final IEXTradingClient iexTradingClient = IEXTradingClient.create();
		
		Quote quote ;
		quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
					        .withSymbol(ticker)
					        .build());
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockPortfolio.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 
			
				     
					try {
						 
				     
				    	System.out.println("0000000000000000000000000000000000000000000000000000000000000000"+pri.getName());

				
						com.stock.dao.StockPortfolio stock = new 	com.stock.dao.StockPortfolio(pri.getName(),quote.getCompanyName(), quote.getSymbol(), quote.getLow(), quote.getHigh(), quote.getChangePercent(),
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
					.addAnnotatedClass(com.stock.dao.StockPortfolio.class)
						.buildSessionFactory();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("-----------------------------------------------------");
		List<StockPortfolio> portfolioQuote =session.createQuery("from com.stock.dao.StockPortfolio").getResultList();
	
		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return portfolioQuote;
 
	}


 




	private List<StockPortfolio> extended(Principal pri) {
		// TODO Auto-generated method stub
		
		
		//getting fetching data from database
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(com.stock.dao.StockPortfolio.class)
				.buildSessionFactory();

					Session session = factory.getCurrentSession();
		 session =factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("--------------------extended(Principal pri)---------------------------------"+ pri.getName()+"a--------");
		List<com.stock.dao.StockPortfolio> portfolioQuote =session.createQuery("from com.stock.dao.StockPortfolio s where s.userName = '"+pri.getName()+"'").getResultList();
		System.out.println(portfolioQuote);
		System.out.println("*******************************************************");
		
		System.out.println("-----------------------------------------------------");
		session.getTransaction().commit();
		
		
		factory.close();
		return portfolioQuote;
		
	}
 


 



	@Override
	public List<StockPortfolio> createQuotePortfolio(String ticker, Principal pri, int quantity, int date) {
		// TODO Auto-generated method stub
		return extended(ticker,pri,quantity,date);
	}
 
	 
 



	@Override
	public List<StockPortfolio> getQuotePortfolio(Principal pri) {
		// TODO Auto-generated method stub
		return extended(pri);
	}




}
 
	
	
	