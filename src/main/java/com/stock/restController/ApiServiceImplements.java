package com.stock.restController;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.stock.dao.Stock;
@Component
public class ApiServiceImplements implements ApiService{

	@Override
	public List<Stock> getQuote() {
	 //starting factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Stock.class)
										.buildSessionFactory();
		
//starting session
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Stock> quote =session.createQuery("from Stock").getResultList();
		
		session.getTransaction().commit();
		
		factory.close();
		
		
		
		return quote;
	}

}
