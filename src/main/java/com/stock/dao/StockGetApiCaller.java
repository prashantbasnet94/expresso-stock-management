package com.stock.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StockGetApiCaller {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
													.configure("hibernate.cfg.xml")
													.addAnnotatedClass(Stock.class)
													.buildSessionFactory();
		
		
		try {
			
			//building a session for operation creation operation in database
			Session session =  factory.getCurrentSession();
			
			
			Stock stock =new Stock();
			
			//beginning transaction
			session.beginTransaction();
			
			//display the stock
			List<Stock>  theStocks = session.createQuery("from Stock").getResultList();
			
			for(Stock stock1 : theStocks){
				System.out.println(stock1.getTicker());
			}
			
	//		session.save(stock);
			session.getTransaction().commit();
			//session closing
			session.close();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			factory.close();

		}
		
		
		
	}

}
