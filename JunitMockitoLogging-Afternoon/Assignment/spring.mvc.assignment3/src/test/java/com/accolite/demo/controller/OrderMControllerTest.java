package com.accolite.demo.controller;


import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.accolite.demo.exception.OrderException;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderMService;

@ExtendWith(MockitoExtension.class)
class OrderMControllerTest {

	@InjectMocks
	OrderMController orderController;
	
	@Mock
	OrderMService orderService;
	
	@Nested 
	class CreateOrderTest {
		
		@Test
		void testCreateOrder_OrderCreated() throws Exception{
			Mockito.when(orderService.createOrder())
	          .thenReturn("Order Created Successfully");
			String response = orderService.createOrder();
			
			Assertions.assertEquals("Order Created Successfully", response);
			Assertions.assertNotNull(response);
			Assertions.assertDoesNotThrow(() -> orderController.createOrder());
		}
		
	}

	@Nested 
	class AddOrderTest {
		
		@Test
		void testAddOrder() throws Exception{
			Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);
			
			 ResponseEntity<Order> response = orderController.addOrder(order);
			 Assertions.assertNotNull(response);//.getBody()
		      
		}
		
		
		@Test
		void testCreateOrder_EmpIdZero() throws Exception {
			Order order = new Order();
			order.setId(0);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);

		      Assertions.assertThrows(OrderException.class,
		          () -> orderController.addOrder(order));

		    }

		    @Test
		    void testAddOrder_PhoneNonNumeric() {
		    	Order order = new Order();
				order.setId(1);
				order.setName("Ravi");
				order.setEmailId("ravi@gmail.com");
				order.setPhone("8888999xyz");
				order.setProduct("Phone");
				order.setQuantity(3);

		      Assertions.assertThrows(Exception.class, () -> orderController.addOrder(order));
		    }

		    @Test
		    void testAddOrder_OrderNull() throws Exception {
		    	 Assertions.assertThrows(Exception.class,() -> orderController.addOrder(null));
		    }
	}

	  @Nested
	  class getOrderByIdTest {

	    @Test
	    void testGetOrderById_OrderExists() {
	    	Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);

	      Mockito.when(orderService.getOrderById(Mockito.anyInt())).thenReturn(order);

	      ResponseEntity<Order> response = orderController.getOrderById(1);
	      Assertions.assertNotNull(response.getBody());
	    }

	    @Test
	    void testGetOrderById_OrderNotExists() {

	      Mockito.when(orderService.getOrderById(Mockito.anyInt())).thenReturn(null);
	      ResponseEntity<Order> response = orderController.getOrderById(10);
	      Assertions.assertNull(response.getBody());
	    }

	  }

	  //////////
	  
	  @Nested
	  class updateOrderTest {
	  @Test
	  void testUpdateOrder_WithMock() {
		  Map<String, Integer> mp = new HashMap<>(); 
			mp.put("quantity", 2);
		
			//
			Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Phone");
			order.setQuantity(3);

	      Mockito.when(orderService.getOrderById(Mockito.anyInt())).thenReturn(order);
	      //
			order.setQuantity(mp.get("quantity"));
			   
			Mockito.doNothing().when(orderService).updateOrder( Mockito.anyObject());
	    orderController.updateOrder(1, mp );
	    
	    ResponseEntity<Order> response = orderController.getOrderById(1);
	      Assertions.assertNotNull(response.getBody());
	    
	  }
	  }

	  
	  @Nested
	  class updateOrder2Test {
	  @Test
	  void testUpdateOrder2_WithMock() {
		  Map<String,String > mp = new HashMap<>(); 
			mp.put("product","Laptop");
			Order order = new Order();
			order.setId(1);
			order.setName("Ravi");
			order.setEmailId("ravi@gmail.com");
			order.setPhone("8888999912");
			order.setProduct("Laptop");
			order.setQuantity(3);

	      Mockito.when(orderService.getOrderById(Mockito.anyInt())).thenReturn(order);
			order.setProduct(mp.get("product"));
			   
			Mockito.doNothing().when(orderService).updateOrder( Mockito.anyObject());
	    orderController.updateOrder2(1, mp );
	    
	    ResponseEntity<Order> response = orderController.getOrderById(1);
	      Assertions.assertNotNull(response.getBody());
	  }
	  
	  }

	   
	  
	  
	  @Nested 
		class DeleteOrderTest {
			
			@Test
			void testDeleteOrder_OrderExists() throws Exception{
				
				Order order = new Order();
				order.setId(1);
				order.setName("Ravi");
				order.setEmailId("ravi@gmail.com");
				order.setPhone("8888999912");
				order.setProduct("Phone");
				order.setQuantity(3);

				
				Mockito.when(orderService.deleteOrder(Mockito.anyInt()))
		          .thenReturn("Deleted Successfully");
				String response = orderService.deleteOrder(1);
				
				Assertions.assertEquals("Deleted Successfully", response);
				Assertions.assertDoesNotThrow(() -> orderController.deleteOrder(1));
			
			}

			@Test
			void testDeleteOrder_OrderDoesNotExists() throws Exception{

				
				Mockito.when(orderService.deleteOrder(Mockito.anyInt()))
		          .thenReturn(null);
				String response = orderService.deleteOrder(10);
				
				 Assertions.assertThrows(OrderException.class, 
						 () -> orderController.deleteOrder(10));
				
			}
			
		}
	  
}
	
	
	

