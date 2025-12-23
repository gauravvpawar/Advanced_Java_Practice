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

import com.example.demo.Model.Items;
import com.example.demo.Service.ItemsService;

@RestController
@RequestMapping("/items")
public class ItemsController 
{
	@Autowired
	ItemsService is;
	
	@GetMapping("/check")
	public String check()
	{
		return "Items mapping working";
	}
	
	@PostMapping("/saveItems")
	public Items saveItems(@RequestBody Items i)
	{
		i.setIid(UUID.randomUUID().toString());
		
		return is.saveItems(i);
	}
	
	// fetch all items
	@GetMapping("/fetchAllItems")
	public List<Items> fetchItems()
	{
		List<Items> allItems =  is.fetchAllItems();
		return allItems;
	}
	
	// fetch items by items id
	@GetMapping("/fetchItemById/{iid}")
	public Items fetchByItemId(@PathVariable String iid)
	{
		return is.fetchItemByItemId(iid);
	}
	
	//fetch items by user id
	@GetMapping("/fetchItemsByUid/{uid}")
	public List<Items> fetchItemsByUId(@PathVariable String uid)
	{
		return is.fetchItemsByUid(uid);
	}
}


