package com.accolite.demo.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderMService;

@ExtendWith(MockitoExtension.class)
class OrderMServiceImplTest {

	@InjectMocks
	OrderMServiceImpl orderService;
	
	static List<Order> orders = new ArrayList<>();
	
	
	@Mock
	OrderMService orderService2;
	
	
	@Nested
	class CreateOrderTest {
		
		@Test
		void testCreateOrder() {
			Mockito.lenient().when(orderService2.createOrder())
	          .thenReturn("Order Created Successfully");
			
			
			String response = orderService.createOrder();
			
			Assertions.assertEquals("Order Created Successfully", response);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> orderService.createOrder());
		}
	}

	
	@Nested
	class AddOrderTest {
		
		@Test
		void testAddOrder() {
			Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);

			Mockito.lenient().when(orderService2.addOrder(order)).thenReturn(order);
			
			Order response = orderService.addOrder(order);
			
			Assertions.assertNotNull(response);
			
		}
	}
	
	
	@Nested
	class GetOrderByIdTest {
		
		@Test
		void testgetOrderById_OrderExists() {
			Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);

			Mockito.lenient().when(orderService2.getOrderById(Mockito.anyInt())).thenReturn(order);
			Order response = orderService.getOrderById(1);
			
			 Assertions.assertNotNull(response);
		}
		
		@Test
	    void testGetOrderById_OrderNotExists() {

	      Order response = orderService.getOrderById(0);
			Assertions.assertNull(response);
	    }

	}
	
	@Nested
	class UpdateOrderTest {
		
		@Test
		void testUpdateOrder() {
			Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);
		
			Assertions.assertDoesNotThrow(() -> orderService.updateOrder(order));
		}
	}

	
	
	@Nested
	class DeleteOrderTest {
		
		@Test
		void testDeleteOrder_OrderExists() {
			Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);
			
			Mockito.lenient().when(orderService2.addOrder(order)).thenReturn(order);
			
			Order response = orderService.addOrder(order);
			String response2 = orderService.deleteOrder(1);
			Assertions.assertNotNull(response2);
			
		}
		
		@Test
	    void testDeleteOrder_OrderNotExists() {

	      String response = orderService.deleteOrder(0);
			Assertions.assertNull(response);
	    }

	}	
	
	
}
