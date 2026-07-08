package com.example.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepo;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepo repo;
	
	public Payment savePayment(Payment payment)
	{
		return repo.save(payment);
	}
	
	public List<Payment> getAllPayments()
	{
		return repo.findAll();
	}
	
	public Payment getPayementById(Long id)
	{
		return repo.findById(id).orElse(null);
	}

}
