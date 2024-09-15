package com.example.order_service.controller;

import com.example.order_service.dto.ProductDto;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.ProductClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductClient productClient;
	
	@PostMapping("/save")
	public Order createOrder(@RequestBody Order order) {
		ProductDto product = productClient.getProductById(order.getProductId());
		order.setTotalPrice(product.getPrice() * order.getQuantity());
		return orderRepository.save(order);
	}
}
