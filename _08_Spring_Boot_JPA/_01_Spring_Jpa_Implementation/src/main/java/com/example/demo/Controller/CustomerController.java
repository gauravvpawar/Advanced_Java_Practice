package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Customer;
import com.example.demo.Service.CustomerService;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerService cs;
	
	@RequestMapping("/check")
	public String check()
	{
		return null;
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/reg")
	public String reg()
	{
		return "Registration";
	}
	
	@RequestMapping("/saveData")
	public String save(@ModelAttribute Customer c1)
	{
		System.out.println(c1);
		
		cs.register(c1);
		
		return "redirect:/";
	}

}
