package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Users;

public interface UserService 
{
	// to save user
	public Users saveUser(Users u1);
	
	public List<Users> getAllUsers();
	
	// to fetch user by uid
	public Users fetchUser(String uid);
}
