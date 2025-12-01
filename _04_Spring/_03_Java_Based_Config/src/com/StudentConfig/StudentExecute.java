package com.StudentConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.First.Student;

@Configuration
public class StudentExecute 
{
	
	@Bean
	public Student one()
	{
		Student s1 = new Student();
		
		s1.setSname("Gaurav");
		s1.setSid(111);
		s1.setSemail("gaurav@gmail.com");
		
		return s1;
	}
}
