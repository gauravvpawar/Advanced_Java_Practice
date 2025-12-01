package com.Run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.First.Restaurant;

public class Main 
{
	public static void main(String args[])
	{
	  ApplicationContext a1 =  new ClassPathXmlApplicationContext("/com/XmlConfig/applicationContext.xml");
	  
	  Restaurant r1 =(Restaurant) a1.getBean("r1");
	  
	  r1.show();
	  
	}
}
