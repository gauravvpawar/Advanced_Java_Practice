package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Items;

public interface ItemsRepo extends JpaRepository<Items, String>
{
	// create custom method to find items by user id
	public List<Items> findItemsByUid(String uid);
}
