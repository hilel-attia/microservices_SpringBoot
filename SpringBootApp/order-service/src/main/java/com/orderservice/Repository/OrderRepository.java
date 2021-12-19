package com.orderservice.Repository;

import org.springframework.data.repository.CrudRepository;

import com.orderservice.Entity.OrderShop;



public interface OrderRepository extends CrudRepository<OrderShop, Integer>{

}
