package com.accolite.demo.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.accolite.demo.exception.OrderException;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderMService;

@RestController
@RequestMapping("/order")
public class OrderMController {
	
	private Logger log  = LoggerFactory.getLogger(OrderMController.class);

		
		@Autowired
		OrderMService orderService;
		
		@PostMapping("/create")
		public ResponseEntity<String> createOrder() throws Exception{ 
		String response = orderService.createOrder();
		 return ResponseEntity.ok(response);
			
		}
		
			@PostMapping("/add")
		public ResponseEntity<Order> addOrder(@RequestBody @Validated Order order)throws Exception
		{ 
			log.info("Order -> {}",order);
		if(order != null) {
			log.debug("order is not null {}", order);
			if(order.getId()==0) {
				log.error("Exception Id can't be zero");
				 throw new OrderException("Id can't be zero");
			}
			if (!StringUtils.isNumeric(order.getPhone())) {
		        throw new Exception("Phone number isn't a number");
		      }
			Order order2 = orderService.addOrder(order);
			return ResponseEntity.ok(order2);
			}
		else {
			log.error("Feilds can't be null");
			 throw new Exception("Feilds can't be null");
			
		}
		
		 
		}
		
		
		@GetMapping("/get/{id}")
		public ResponseEntity<Order> getOrderById(@PathVariable("id") @NonNull int id) {
			Order order = (Order) orderService.getOrderById(id);
			if(Objects.nonNull(order)) {
				log.info("Order -> {}",order);
				return ResponseEntity.ok(order);
			}
			else {
				log.info("Order not found");
				return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
			}
			
		}
		
		@PutMapping("/update/{id}")
		public ResponseEntity<Order> updateOrder(
				@PathVariable("id") @NonNull Integer id,
				@RequestBody  Map<String, Integer> orderdet2
				) {
			Integer quantity = orderdet2.get("quantity");
			Order order = (Order) orderService.getOrderById(id);
			order.setQuantity(quantity);
			orderService.updateOrder(order);
			log.info("Order data updated quantity");
			return ResponseEntity.ok(order);
			
		}

		@PutMapping("/update2/{id}")
		public ResponseEntity<Order> updateOrder2(
				@PathVariable("id") @NonNull Integer id,
				@RequestBody  Map<String, String> orderdet1
				) {
			String product = orderdet1.get("product");
			Order order = (Order) orderService.getOrderById(id);
			order.setProduct(product);
			orderService.updateOrder(order);
			log.info("Order data updated product");			
			return ResponseEntity.ok(order);
			
		}
		
		
		@DeleteMapping("/delete/{id}")
		public String deleteOrder(@PathVariable("id") @NonNull int id) throws Exception{
		    	String response = orderService.deleteOrder(id);
		    	if(response != null)
		    	{
					log.info("Order deleted");
		    		return response;
		    	}
		    	else
		    	{
		    		log.error("No such order exists");
				 throw new OrderException("No such order exists");
		    	}
				
		}

	
}
