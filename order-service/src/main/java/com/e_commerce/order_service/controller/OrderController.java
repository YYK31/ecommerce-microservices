package com.e_commerce.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.order_service.dto.OrderRequest;
import com.e_commerce.order_service.dto.OrderResponce;
import com.e_commerce.order_service.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	 @PostMapping
	    public ResponseEntity<OrderResponce> placeOrder(@RequestBody OrderRequest request) {
	        return orderService.placeOrder(request);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getOrder(@PathVariable Long id) {
	        return orderService.getOrderById(id);
	    }
	
	
}
