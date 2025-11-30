package com.First;

public class Laptop 
{
	private String Lname;
	private String Lcompany;
	private int Lcost;
	
	private Processor p1;
	
	
	public Laptop(String Lname , String Lcompany , int Lcost , Processor p1)
	{
		this.Lname = Lname;
		this.Lcompany = Lcompany;
		this.Lcost = Lcost;
		
		this.p1 = p1;
	}
	
	
	public void show()
	{
		System.out.println("Laptop Name : " + Lname);
		System.out.println("Laptop Company : " + Lcompany);
		System.out.println("Laptop cost : " + Lcost);
		
		System.out.println("Processor data : " + p1);
	}
	
	

	
	
}
