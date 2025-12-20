package com.example.demo.Service;

import com.example.demo.Model.Manager;

public interface ManagerService
{
	public void saveManager(Manager m);
	
	public void deleteManager(String id);
	
	public Manager fetchManager(String id);
}
