package com.accolite.demo.service;

import com.accolite.demo.model.Order;

public interface OrderMService {
	
	public String createOrder();

	public Order addOrder(Order order);
	
	public Order getOrderById(int id);
	
	public void updateOrder(Order order);
	
	public String deleteOrder(int id);

	

}
