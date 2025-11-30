package com.Run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.First.Laptop;

public class Main 
{
	
	public static void main(String args[])
	{	
		ApplicationContext a1 = new ClassPathXmlApplicationContext("/com/XmlConfig/applicationContext.xml");
		
		Laptop l1 = (Laptop) a1.getBean("l1");
		
		l1.show();
		
	}
}
