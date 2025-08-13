package com.e_commerce.product_service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.product_service.entity.Product;

@Repository
public interface ProductInterface extends JpaRepository<Product, Long> {


	
}
