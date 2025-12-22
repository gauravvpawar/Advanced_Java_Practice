package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Items;
import com.example.demo.Repo.ItemsRepo;
import com.example.demo.Service.ItemsService;

@Service
public class ItemsDao implements ItemsService
{
	@Autowired
	ItemsRepo ir;
	
	public Items saveItems(Items i)
	{
		return ir.save(i);
	}

	public List<Items> fetchAllItems() {
		return ir.findAll();
	}
	
	public Items fetchItemByItemId(String iid)
	{
		return ir.findById(iid).orElse(null);
	}

	@Override
	public List<Items> fetchItemsByUid(String uid) {
		List<Items> itemsList = ir.findItemsByUid(uid);
		return itemsList;
	}
}
