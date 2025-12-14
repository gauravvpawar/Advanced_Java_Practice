package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.UserService;

@Service
public class UserDao implements UserService
{
	@Autowired
	UserRepo ur;
	
	public void registerUser(User u)
	{
		ur.save(u);
	}

	@Override
	public List<User> getAllUser() {
		
		return ur.findAll();
	}

	@Override
	public void deleteUser(String id) {
		
		ur.deleteById(id);
	}
	
	public User fetchSingleUser(String id)
	{
		return ur.findById(id).orElse(null);
	}

}
