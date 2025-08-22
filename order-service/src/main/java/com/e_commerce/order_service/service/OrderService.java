package com.e_commerce.order_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.e_commerce.order_service.dto.OrderRequest;
import com.e_commerce.order_service.dto.OrderResponce;
import com.e_commerce.order_service.entity.Order;
import com.e_commerce.order_service.entity.OrderStatus;
import com.e_commerce.order_service.impl.OrderInterface;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class OrderService {

	@Autowired
	private OrderInterface orderInterface;
	
	  public ResponseEntity<OrderResponce> placeOrder(OrderRequest request) {
	        Order order = Order.builder()
	                .productId(request.getProductId())
	                .quantity(request.getQuantity())
	                .price(request.getPrice())
	                .status(OrderStatus.PENDING)
	                .orderDate(LocalDateTime.now())
	                .build();

	           orderInterface.save(order);

	        return ResponseEntity.ok(
	                new OrderResponce(order.getId(), "Order placed successfully")
	        );
	    }
	  
	  
	  public ResponseEntity<?> getOrderById(Long id) {
	        Order order = orderInterface.findById(id)
	                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
	        return ResponseEntity.ok(order);
	    }
	  
	  
}
