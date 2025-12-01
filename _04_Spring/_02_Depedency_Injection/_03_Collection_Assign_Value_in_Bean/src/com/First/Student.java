package com.First;

public class Student 
{
	private String sname;
	private String sid;
	private String sclass;
	
	public Student(String sname , String sid , String sclass)
	{
		this.sname = sname;
		this.sid = sid;
		this.sclass = sclass;
	}

	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sid=" + sid + ", sclass=" + sclass + "]";
	}
	
	
	
	
}
