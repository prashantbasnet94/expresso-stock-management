package com.stock.aop.populateApi;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
		        .withSymbol("AAPL")
		        .build());
		System.out.println("<--------------------"+quote);
		
		
	}
	
}
