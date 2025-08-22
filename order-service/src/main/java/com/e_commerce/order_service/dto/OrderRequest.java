package com.e_commerce.order_service.dto;


import lombok.Data;

@Data
public class OrderRequest {

	    private Long productId;
	    private Integer quantity;
	    private Double price;
}
