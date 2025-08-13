package com.e_commerce.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.product_service.entity.Product;
import com.e_commerce.product_service.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	//Add Product
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
	return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
	}
	
	//getAllProduct
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(){
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	//getProductById
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
	}
	
	//deleteProduct
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		productService.deleteById(id);
		return new ResponseEntity<String>("Product Deleted Successfully",HttpStatus.OK);
	}
	
	//update product
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id ,@RequestBody Product updateProduct){
		productService.updateProduct(id, updateProduct);
		return new ResponseEntity<String>("Product Updated Successfully",HttpStatus.OK);
	}
	
	
}
