package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Payments;
import com.example.demo.Repo.PaymentsRepo;
import com.example.demo.Service.PaymentsService;

@Service
public class PaymentsDao implements PaymentsService
{
	@Autowired
	PaymentsRepo pr;
	
	@Override
	public Payments savePayments(Payments p) {
		
		return pr.save(p);
	}
	
	public List<Payments> getAllPayments()
	{
		return pr.findAll();
	}
	
	public Payments fetchPaymentByPid(String pid)
	{	
		return pr.findById(pid).orElse(null);
	}
	
	public Payments fetchPaymentByItemId(String iid)
	{
		return pr.findPaymentsByIid(iid);
	}

}
