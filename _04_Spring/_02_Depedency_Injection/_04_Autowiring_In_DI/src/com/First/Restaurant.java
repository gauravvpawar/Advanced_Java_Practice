package com.First;

public class Restaurant 
{
	private String rname;
	private String raddress;
	private int rrating;
	
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


	public int getRrating() {
		return rrating;
	}


	public void setRrating(int rrating) {
		this.rrating = rrating;
	}


	public Waiter getW1() {
		return w1;
	}


	public void setW1(Waiter w1) {
		this.w1 = w1;
	}


	public  void show()
	{
		System.out.println("Restaurant Information : ");
		System.out.println("Restaurant name : " + this.getRname());
		System.out.println("Restaurant address : " + this.getRaddress());
		System.out.println("Restaurant rating :" + this.getRrating());
		
		System.out.println("Waiters info : ");
		System.out.println(w1.getWname());
		System.out.println(w1.getWid());
		System.out.println(w1.getWemail());
		
	}
	
	
	
	
}
