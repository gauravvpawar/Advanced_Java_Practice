package com.First;

public class Processor 
{
	private String pname;
	private int pGenration;
	
	
	public Processor(String pname , int pGeneration)
	{
		this.pname = pname;
		this.pGenration = pGeneration;
	}
	
	@Override
	public String toString() {
		return "Processor [pname=" + pname + ", pGenration=" + pGenration + "]";
	}
	
	
	
	
	
}
