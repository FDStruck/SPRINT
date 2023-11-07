package com.sprint_4.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint_4.crm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
