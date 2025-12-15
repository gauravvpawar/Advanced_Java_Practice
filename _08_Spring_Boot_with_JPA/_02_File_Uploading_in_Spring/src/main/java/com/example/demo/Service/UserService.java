package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.User;

public interface UserService 
{
	public void registerUser(User u);
	
	public List<User> getAllUser();
	
	// to delete user
	public void deleteUser(String id);
	
	public User fetchSingleUser(String uid);
	
	// custom JPA Method
	public User fetchUser(String email , String password);
}
