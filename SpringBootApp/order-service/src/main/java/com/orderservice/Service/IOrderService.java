package com.orderservice.Service;

import java.util.List;

import com.orderservice.Entity.OrderShop;




public interface IOrderService {
	
	public OrderShop addOrder(OrderShop order);
	public OrderShop getOrderById(int orderId);
	public List<OrderShop> getAllOrders();
	public void deleteOrderById(int orderId);

}
