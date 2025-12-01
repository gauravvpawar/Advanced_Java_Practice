package com.Run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.First.College;


public class Main
{	
	public static void main(String args[])
	{
		ApplicationContext a1 = new ClassPathXmlApplicationContext("/com/XmlConfig/applicationContext.xml");
		
		College c1 = (College) a1.getBean("c1");
		
		c1.show();
	}
}
