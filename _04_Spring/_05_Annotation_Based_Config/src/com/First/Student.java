package com.First;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student
{
	@Value("Gaurav")
	private String sname;
	
	@Value("112")
	private int sid;
	
	@Value("gaurav@gmail.com")
	private String semail;
	
	public void show()
	{
		System.out.println("Student data : ");
		System.out.println("Student name : " + sname);
		System.out.println("student id : " + sid);
		System.out.println("Student email : " + semail);
	}
	
}
