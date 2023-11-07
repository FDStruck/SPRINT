package com.sprint_4.crm.service;

import java.util.List;

import com.sprint_4.crm.exception.ClientNotFoundException;
import com.sprint_4.crm.exception.ProductNotFoundException;
import com.sprint_4.crm.model.Client;
import org.springframework.stereotype.Service;

import com.sprint_4.crm.model.Product;
import com.sprint_4.crm.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductRepository productRepository;
	
	//create single product
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	//create list product
	public List<Product> createListClient(List<Product> client) {
		return productRepository.saveAll(client);
	}
	
	//return all product
	public List<Product> getAllProducts() throws ProductNotFoundException {
		if (productRepository.findAll() == null)
			throw new ProductNotFoundException("Nao existe produtos");
		else
			return productRepository.findAll();
	}

	public Product getProduct(Long id) throws ProductNotFoundException {
		Product product = productRepository.findById(id).orElse(null);
		if (product != null)
			return productRepository.findById(id).orElse(null);
		else
			throw new ProductNotFoundException("Não existe este produto " + id);
	}
}
