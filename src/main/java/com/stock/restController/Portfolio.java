package com.stock.restController;

import java.security.Principal;

import org.springframework.web.bind.annotation.PathVariable;

public class Portfolio {
	private String id;
	private Principal pri;
	private int quantity;
	private int date;
	
	public Portfolio(@PathVariable String id,Principal pri,int quantity,int date) {
		this.setId(id);
		this.setPri(pri);
		this.quantity = quantity;
		this.date = date;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Principal getPri() {
		return pri;
	}

	public void setPri(Principal pri) {
		this.pri = pri;
	}

}
