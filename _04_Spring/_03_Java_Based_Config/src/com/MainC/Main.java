package com.MainC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.First.Student;
import com.StudentConfig.StudentExecute;

public class Main 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext a1 = new AnnotationConfigApplicationContext(StudentExecute.class);
		
		Student s1 = (Student) a1.getBean("one");
		
		s1.show();
				
	}
}
