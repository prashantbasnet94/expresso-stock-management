package com.stock.aop.populateApi;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.stock.dao.StockOperator;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@Aspect
@Component
public class AspectClass {
	@Before("execution(public void com.stock.test.Test.test1())")
	public void beforeTest() {
		

		
		
		final IEXTradingClient iexTradingClient = IEXTradingClient.create();
		final Quote quote = iexTradingClient.executeRequest(new QuoteRequestBuilder()
		        .withSymbol("fb")
		        .build());
		
		
		
		
		System.out.println(quote.getCompanyName()+
				quote.getSymbol()+
				quote.getLow()+" "+
				quote.getHigh()+" "
				+quote.getChangePercent()+" "+
				quote.getLatestVolume()+" "+
				quote.getMarketCap()
				+" "+ quote.getPrimaryExchange()
				
				
				
				);
		StockOperator.save(0,quote.getCompanyName(), quote.getSymbol(), quote.getLow(), quote.getHigh(), quote.getChangePercent(),
				quote.getLatestVolume(), quote.getMarketCap(), quote.getOpen()) ;
		
 		
	}
	
}
