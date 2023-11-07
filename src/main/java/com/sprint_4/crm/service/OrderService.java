package com.sprint_4.crm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sprint_4.crm.exception.ClientNotFoundException;
import com.sprint_4.crm.exception.OrderNotFoundException;
import com.sprint_4.crm.exception.ProductNotFoundException;
import com.sprint_4.crm.model.Client;
import com.sprint_4.crm.model.Product;
import com.sprint_4.crm.request.OrderRequest;
import org.springframework.stereotype.Service;

import com.sprint_4.crm.model.Order;
import com.sprint_4.crm.repository.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private ClientService clientService;
    private ProductService productService;


    //create single order
    public Order createOrder(OrderRequest orderRequest) throws ClientNotFoundException, ProductNotFoundException {

        Client client = clientService.getClient(orderRequest.getClientID());

        if (client == null)
            throw new ClientNotFoundException("Nao foi encontrado este cliente");

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setClient(clientService.getClient(orderRequest.getClientID()));

        List<Product> products = new ArrayList<>();
        List<Long> quantity = new ArrayList<>();

        double price = 0.0;

        for (int i = 0; i < orderRequest.getProductID().size(); i++) {
            Long productId = orderRequest.getProductID().get(i);
            Product product = productService.getProduct(productId);
            if (product == null)
                throw new ProductNotFoundException("Produnao nao existe");
            products.add(product);
            quantity.add(orderRequest.getQuantity().get(i));
            price += productService.getProduct(productId).getPrice() * orderRequest.getQuantity().get(i);
        }
        order.setProducts(products);
        order.setProductQuantity(quantity);
        order.setPrice(price);

        return orderRepository.save(order);
    }

    //create list order
    public List<Order> createListOrder(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    //return all Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //return single Orders
    public Order getOrder(Long id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null)
            throw new OrderNotFoundException("Ordem nao encontrada");
        else
            return order;
    }
}
