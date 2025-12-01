package com.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.First.Restaurant;
import com.First.Waiter;

@Configuration
public class RestaurantConfig 
{
	@Bean
	public Restaurant one()
	{
		Restaurant r1 = new Restaurant();
		
		r1.setRname("Atithya");
		r1.setRaddress("pmc");
		r1.setRpincode(411011);
		
		r1.setW1(two());
		
		return r1;
	}
	
	
	@Bean
	public Waiter two()
	{
		Waiter w1 = new Waiter();
		w1.setWname("natu kaka");
		w1.setWaddress("mumbai");
		
		return w1;
	}
}
