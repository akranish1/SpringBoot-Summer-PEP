package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.service.OrderService;
import com.example.demo.entity.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService serv;
	public OrderController(OrderService serv)
	{
		this.serv=serv;
	}
	
	@PostMapping
	public Order create(@RequestBody Order order) {
		return serv.save(order);
	}

	@GetMapping
	public List<Order> getAll() {
		return serv.getAll();
	}
	
	

}
