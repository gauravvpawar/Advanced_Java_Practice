package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Manager;
import com.example.demo.Repo.ManagerRepo;
import com.example.demo.Service.ManagerService;

@Service
public class ManagerDao implements ManagerService
{
	@Autowired
	ManagerRepo mr;
	
	public void saveManager(Manager m)
	{
		mr.save(m);
	}

	@Override
	public void deleteManager(String id) {
		mr.deleteById(id);
	}

	@Override
	public Manager fetchManager(String id) {
		return mr.findById(id).orElse(null);
	}	
}
