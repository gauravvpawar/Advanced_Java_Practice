package com.First;

public class Restaurant 
{
	private String rname;
	private String raddress;
	private int rpincode;
	
	private Waiter w1;
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public int getRpincode() {
		return rpincode;
	}
	public void setRpincode(int rpincode) {
		this.rpincode = rpincode;
	}
	
	
	public Waiter getW1() {
		return w1;
	}
	public void setW1(Waiter w1) {
		this.w1 = w1;
	}
	public void show()
	{
		System.out.println("Restaurant details :");
		System.out.println("Restaurant name : " + rname);
		System.out.println("Restaurant raddress : " + raddress);
		System.out.println("Restaurant pincode : " + rpincode);
		
		System.out.println("Waiter details : ");
		System.out.println("Waiter name : " + w1.getWname());
		System.out.println("waiter address : " + w1.getWaddress());
	}
	
	
	
}
