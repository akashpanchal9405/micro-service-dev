package com.inn.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.transaction.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
