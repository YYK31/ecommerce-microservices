package com.e_commerce.product_service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.e_commerce.product_service.entity.Product;
import com.e_commerce.product_service.exception.ProductNotFoundException;
import com.e_commerce.product_service.impl.ProductInterface;

@Service
public class ProductService{
	
	@Autowired
	private ProductInterface productInterface;
	
	public Product addProduct(Product product) {
		return productInterface.save(product);
		
	}
	
	public List<Product> getAllProducts(){
		return productInterface.findAll();
	}
	
	public Product getProductById(Long id){
		return productInterface.findById(id).orElseThrow(() ->new ProductNotFoundException("Product with "+ id +" Not Found"));
	}
	
	public void deleteById(Long id) {
		Product product = productInterface.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with "+ id +" Not Found"));
		productInterface.delete(product);
		
	}
	
	/*
	 * public void deleteById(Long id) {
		Product product = getProductById(id);
		productInterface.delete(product);
	}
	*/
	
	public Product updateProduct(Long id, Product updateProduct) {
		
		Product product = getProductById(id);
		product.setName(updateProduct.getName());
		product.setDescription(updateProduct.getDescription());
		product.setPrice(updateProduct.getPrice());
		product.setQuantity(updateProduct.getQuantity());
				
		return productInterface.save(product);
	}

}
