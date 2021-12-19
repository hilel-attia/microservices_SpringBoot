package com.orderservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.Entity.OrderShop;
import com.orderservice.Service.IOrderService;



@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	
	@Autowired
	IOrderService orderService;
	
	
	@GetMapping("/orders")
	@ResponseBody
	public List<OrderShop> getAllUsers() {
			
		return orderService.getAllOrders();
	}
	

	@PostMapping("/addOrder")
	@ResponseBody
	public OrderShop ajouterEntreprise(@RequestBody OrderShop order) {
		orderService.addOrder(order);
		return order;
	}
	
    @DeleteMapping("/deleteOrder/{idOrder}") 
	@ResponseBody 
	public void deleteEntrepriseById(@PathVariable("idOrder")int orderId)
	{
    	orderService.deleteOrderById(orderId);
	}
    
   
    @GetMapping("/getOrderById/{idOrder}")
    @ResponseBody
	public OrderShop getOrderById(@PathVariable("idOrder") int orderId) {

		return orderService.getOrderById(orderId);
	}

}
