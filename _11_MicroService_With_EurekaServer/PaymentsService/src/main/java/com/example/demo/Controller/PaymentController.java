package com.example.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Payments;
import com.example.demo.Service.PaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentController 
{
	@Autowired
	PaymentsService ps;
	
	@GetMapping("/check")
	public String check()
	{
		return "Payments mapping working";
	}
	
	// to save payments
	@PostMapping("/savePayments")
	public Payments savePayments(@RequestBody Payments p)
	{
		p.setPid(UUID.randomUUID().toString());
		ps.savePayments(p);
		return p;
	}
	
	// to fetch all payments
	@GetMapping("/getAllPayments")
	public List<Payments> getPayments()
	{
		return ps.getAllPayments();
	}
	
	// to fetch payment by payment id;
	@GetMapping("/fetchPayment/{pid}")
	public Payments fetchPayment(@PathVariable String pid)
	{
		return ps.fetchPaymentByPid(pid);
	}	
	
	// to fetch payment by item id
	@GetMapping("/fetchPaymentByItemId/{iid}")
	public Payments fetchPaymentByItemId(@PathVariable String iid)
	{
		return ps.fetchPaymentByItemId(iid);
	}
	
}
