package com.sprint_4.crm.controller;

import java.util.List;

import com.sprint_4.crm.exception.ClientNotFoundException;
import com.sprint_4.crm.exception.OrderNotFoundException;
import com.sprint_4.crm.exception.ProductNotFoundException;
import com.sprint_4.crm.model.Client;
import com.sprint_4.crm.request.OrderRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sprint_4.crm.model.Order;
import com.sprint_4.crm.service.OrderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

	private OrderService orderService;
	
	@PostMapping("/addOrders")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderRequest orderRequest) throws ClientNotFoundException, ProductNotFoundException {
        Order createdOrder = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }
	
	@GetMapping("/getOrders")
	public ResponseEntity<List<Order>> getAllOrders(){
		return ResponseEntity.ok(orderService.getAllOrders());
	 }

	@GetMapping("/getOrders/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id) throws OrderNotFoundException {
		return ResponseEntity.ok(orderService.getOrder(id));
	}
}
