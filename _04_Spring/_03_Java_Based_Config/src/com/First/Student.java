package com.First;

public class Student 
{
	private String sname;
	private int sid;
	private String semail;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	
	public void show()
	{
		System.out.println("Student data : ");
		System.out.println("Student name : " + sname);
		System.out.println("Student id : " + sid);
		System.out.println("Student email : " + semail);
	}
	
}
