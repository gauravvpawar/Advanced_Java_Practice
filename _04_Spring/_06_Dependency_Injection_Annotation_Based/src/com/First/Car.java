package com.First;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Value("BMW")
	private String cname;
	
	@Value("4242")
	private int cnumber;
	
	@Value("BMW m5 2025")
	private String cmodel;
	
	@Autowired
	private Engine e1;
	
	
	public void show()
	{
		System.out.println("Car details : ");
		System.out.println("Car name : " + cname);
		System.out.println("Car number : " + cnumber);
		System.out.println("Car model number : " + cmodel);
		
		System.out.println("----------------Engine Details----------------------");
		e1.show();
	}
	
}
