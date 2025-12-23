package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Payments;

public interface PaymentsService 
{
	// to save payments
	public Payments savePayments(Payments p);
	
	// to get all payments list
	public List<Payments> getAllPayments();
	
	// fetch payment by its payment id
	public Payments fetchPaymentByPid(String pid);
	
	// fetch payment by item id
	public Payments fetchPaymentByItemId(String id);
}
