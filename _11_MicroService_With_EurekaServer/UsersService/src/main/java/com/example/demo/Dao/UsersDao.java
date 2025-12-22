package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Users;
import com.example.demo.Repo.UsersRepo;
import com.example.demo.Service.UserService;

@Service
public class UsersDao implements UserService
{
	@Autowired
	UsersRepo ur;
	
	@Autowired
	RestTemplate obj;
	
	public Users saveUser(Users u1)
	{
		return ur.save(u1);
	}

	@Override
	public List<Users> getAllUsers() {
		
		return ur.findAll();
	}

	@Override
	public Users fetchUser(String uid) {
		
		Users user =  ur.findById(uid).orElse(null);
		
		List items =  obj.getForObject("http://localhost:9092/items/fetchItemsByUid/"+uid, ArrayList.class);
		
		user.setItemList(items);
		
		return user;
	}
}
