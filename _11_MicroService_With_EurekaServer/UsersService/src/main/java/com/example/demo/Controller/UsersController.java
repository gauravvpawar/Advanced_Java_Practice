package com.example.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Users;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/users")
public class UsersController 
{
	@Autowired
	UserService us;
	
	@GetMapping("/check")
	public String check()
	{
		return "Mapping is working";
	}

	
	@PostMapping("/saveUser")
	public  Users saveUser(@RequestBody Users u1)
	{
		u1.setUid(UUID.randomUUID().toString());
		
		us.saveUser(u1);
		return u1;
	}
	
	// to get all users
	@GetMapping("/getAllUsers")
	public List<Users> getAll()
	{
		return us.getAllUsers();
	}
	
	// to fetch the user by uid
	@GetMapping("/fetchUser/{uid}")
	public Users fetchUser(@PathVariable String uid)
	{
		return us.fetchUser(uid);
	}
}
