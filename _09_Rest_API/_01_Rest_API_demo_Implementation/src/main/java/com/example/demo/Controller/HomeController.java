package com.example.demo.Controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Manager;

@RestController
public class HomeController 
{
	@GetMapping("/check")
	public String msg()
	{
		return "Welcome Your mapping is working";
	}
	
	@PostMapping("/register")
	public String reg(@RequestBody Manager m)
	{
		m.setMid(UUID.randomUUID().toString());
		
		return "User Registered";
	}
}
