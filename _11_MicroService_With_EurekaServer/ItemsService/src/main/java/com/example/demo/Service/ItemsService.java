package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Items;

public interface ItemsService 
{
	public Items saveItems(Items i);
	
	public List<Items> fetchAllItems();
	
	public Items fetchItemByItemId(String iid);
	
	public List<Items> fetchItemsByUid(String uid);
}
