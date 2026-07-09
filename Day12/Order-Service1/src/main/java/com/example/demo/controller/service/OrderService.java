package com.example.demo.controller.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repo.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository repo;
	public OrderService(OrderRepository repo)
	{
		this.repo=repo;
	}
	
	public Order save(Order order)
	{
		return repo.save(order);
	}
	public java.util.List<Order> getAll()
	{
		return repo.findAll();
	}
}
