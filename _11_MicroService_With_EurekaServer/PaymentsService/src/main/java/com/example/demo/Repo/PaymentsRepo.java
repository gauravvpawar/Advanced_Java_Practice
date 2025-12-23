package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Payments;

public interface PaymentsRepo extends JpaRepository<Payments, String>
{
	// create custom method for to fetch payment by pid
	public Payments findPaymentsByIid(String iid);
}
	