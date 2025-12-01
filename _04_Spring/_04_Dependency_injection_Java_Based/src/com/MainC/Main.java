package com.MainC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Config.RestaurantConfig;
import com.First.Restaurant;

public class Main {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext a1 = new AnnotationConfigApplicationContext(RestaurantConfig.class);
		
		Restaurant r1 = (Restaurant) a1.getBean("one");
		
		r1.show();
	}
}
