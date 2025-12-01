package com.Run;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.First.Student;

public class Main 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext a1 = new AnnotationConfigApplicationContext();
		
		a1.refresh(); // to refresh it first
		
		a1.register(Student.class);
		
		Student s1 = (Student) a1.getBean("student");
		
		s1.show();
	}
}
