package com.Run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.First.Clinic;


public class Main {
	
	public static void main(String args[])
	{
	
		ApplicationContext a1 = new ClassPathXmlApplicationContext("/com/XmlConfig/applicationContext.xml");
		
		Clinic c1 = (Clinic)a1.getBean("c1");
		
		c1.showData();
	}
}
