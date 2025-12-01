package com.Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Config.AppConfig;
import com.First.Car;

public class Main 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext a1 = new AnnotationConfigApplicationContext(AppConfig.class);
		
//		a1.refresh();
//		
		// you have to first register class file
	 	Car c1 = (Car) a1.getBean(Car.class);
		
		c1.show();
		
		a1.close();
		
	}
}
