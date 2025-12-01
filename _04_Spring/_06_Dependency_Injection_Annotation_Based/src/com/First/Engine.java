package com.First;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine
{
	@Value("W engine")
	private String ename;
	
	@Value("2000cc Power")
	private String ePower;
	
	
	
	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getePower() {
		return ePower;
	}



	public void setePower(String ePower) {
		this.ePower = ePower;
	}



	public void show()
	{
		System.out.println("Engine name : " + ename);
		System.out.println("Engine Power : " + ePower);
	}
	
}
