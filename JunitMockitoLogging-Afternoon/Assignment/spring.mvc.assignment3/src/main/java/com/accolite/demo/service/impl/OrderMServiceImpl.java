package com.accolite.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderMService;

@Service
public class OrderMServiceImpl implements OrderMService{
	static List<Order> orders = new ArrayList<>();
	
	@Override
	public String createOrder(){
	return "Order Created Successfully";
	}
	

	@Override
	public Order addOrder( Order order) {
		orders.add(order);
		return order;
	}
	
	
	@Override
	public Order getOrderById(int id) {
		Optional<Order> order = orders.stream().filter( e-> id == e.getId()).findFirst();
		
		if(order.isPresent()) {
			return order.get();
		}
		else{
			return null;
		}
	}
	
	@Override
	public void updateOrder(Order order) {
			
			orders.add(order);
			
	}
	
	@Override
	public String deleteOrder(int id) {
		Optional<Order> order = orders.stream().filter( e-> id == e.getId()).findFirst();
		
		if(order.isPresent())
		{
		orders.remove(id);
		return "Deleted Successfully";
		}
		else
		return null;
	}

}
