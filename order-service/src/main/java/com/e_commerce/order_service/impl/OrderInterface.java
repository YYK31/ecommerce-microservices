package com.e_commerce.order_service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.order_service.entity.Order;

public interface OrderInterface extends JpaRepository<Order, Long> {

	
}
