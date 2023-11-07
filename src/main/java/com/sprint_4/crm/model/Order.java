package com.sprint_4.crm.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_TBL")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private long orderID;
    @ManyToOne
    private Client client;
    @Column(name = "orderDate")
    private LocalDate orderDate;
    @Column(name = "delieveryDate")
    private LocalDate delieveryDate;
    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "Order_Product",
            joinColumns = @JoinColumn(name = "orderID"),
            inverseJoinColumns = @JoinColumn(name = "productID")
    )
    private List<Product> products;
    private List<Long> productQuantity;

}
