package com.sprint_4.crm.controller;

import java.util.List;

import com.sprint_4.crm.exception.ClientNotFoundException;
import com.sprint_4.crm.exception.ProductNotFoundException;
import com.sprint_4.crm.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint_4.crm.model.Product;
import com.sprint_4.crm.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;
	
	@PostMapping("/addProducts")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException {
		return ResponseEntity.ok(productService.getAllProducts());
	 }

	@GetMapping("/getProducts/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) throws ProductNotFoundException {
		return ResponseEntity.ok(productService.getProduct(id));
	}
}
