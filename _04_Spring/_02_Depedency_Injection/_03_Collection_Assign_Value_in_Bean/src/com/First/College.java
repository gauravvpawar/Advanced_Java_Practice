package com.First;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class College 
{
	private String cname;
	private String caddress;
	private int cnumber;
	
	private Student s1;
	
	// to add the list
	private List<String> subjects;
	
	// set
	private Set scourse;
	
	// for the map
	private Map totalCount;
	
	public College(String cname , String caddress , int cnumber ,Student s1 ,List<String> subjects , Set scource , Map totalCount)
	{
		this.cname = cname;
		this.caddress = caddress;
		this.cnumber = cnumber;
		
		this.s1 = s1;
		
		this.subjects  = subjects;
		
		this.scourse = scource;
		
		this.totalCount = totalCount;
	}
	
	
	public void show()
	{
		System.out.println("College Details : ");
		System.out.println("College name : " + cname);
		System.out.println("College address : " + caddress);
		System.out.println("College number : " + cnumber);
		
		System.out.println("Student details : ");
		System.out.println(s1);
		
		//show subjects
		System.out.println("Subjects : ");
		Iterator i1 =   subjects.iterator();
			
		while(i1.hasNext())
		{
			System.out.println(i1.next());
		}
		
		// show courses
		System.out.println("Show cources : ");
		Iterator i2 = scourse.iterator();
		
		while(i2.hasNext())
		{
			System.out.println(i2.next());
		}
		
		
		//total counts
		System.out.println("Total Student in cources");
		
		Set se = totalCount.entrySet();
		Iterator i3 = se.iterator();
		
		while(i3.hasNext())
		{
			System.out.println(i3.next());
		}
		
	}


}
