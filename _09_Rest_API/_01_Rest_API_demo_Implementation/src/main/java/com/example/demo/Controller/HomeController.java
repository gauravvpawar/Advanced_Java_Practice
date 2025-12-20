package com.example.demo.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Manager;
import com.example.demo.Service.ManagerService;

@RestController
public class HomeController 
{
	@Autowired
	ManagerService ms;
	
	@GetMapping("/check")
	public String msg()
	{
		return "Welcome Your mapping is working";
	}
	
	// to register user
	@PostMapping("/register")
	public String reg(@RequestBody Manager m)
	{
		m.setMid(UUID.randomUUID().toString());
		
		System.out.println(m);
		
		ms.saveManager(m);
		
		return "User Registered";
	}
	
	// to delete user by user id
	@DeleteMapping("/delManager/{id}")
	public String del(@PathVariable String id)
	{
		ms.deleteManager(id);
		return "Manager deleted";
	}
	
	// to update the user
	@PutMapping("/updateManager/{id}")
	public String updateData(@PathVariable String id , @RequestBody Manager m)
	{
		Manager manager = ms.fetchManager(id);
		
		if(m.getMname() != null)
		{
			manager.setMname(m.getMname());
		}
		
		if(m.getMemail() != null)
		{
			manager.setMemail(m.getMemail());
		}
		
		if(m.getMpassword() != null)
		{
			manager.setMpassword(m.getMpassword());
		}
		
		ms.saveManager(manager);
		
		return "Data updated successfully";
	}
	
	
	
}
