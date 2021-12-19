package com.orderservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.Entity.OrderShop;
import com.orderservice.Repository.OrderRepository;




@Service
public class OrderService implements IOrderService{

	
	@Autowired
	OrderRepository orderRepository;
	

	@Override
	public List<OrderShop> getAllOrders() {
		
		return  (List<OrderShop>) orderRepository.findAll();
	}



	@Override
	public OrderShop addOrder(OrderShop order) {
		orderRepository.save(order);
		return order;
	}

	@Override
	public void deleteOrderById(int orderId) {
		orderRepository.delete(orderRepository.findById(orderId).get());
		
	}


	@Override
	public OrderShop getOrderById(int orderId) {
	
		return orderRepository.findById(orderId).get();	
	}

}
