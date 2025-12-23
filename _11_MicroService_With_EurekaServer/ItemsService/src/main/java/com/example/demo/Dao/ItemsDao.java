package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Items;
import com.example.demo.Model.Payments;
import com.example.demo.Repo.ItemsRepo;
import com.example.demo.Service.ItemsService;

@Service
public class ItemsDao implements ItemsService
{
	@Autowired
	ItemsRepo ir;
	
	@Autowired
	RestTemplate obj;
	
	public Items saveItems(Items i)
	{
		return ir.save(i);
	}

	public List<Items> fetchAllItems() {
		return ir.findAll();
	}
	
	public Items fetchItemByItemId(String iid)
	{
		Items item =  ir.findById(iid).orElse(null);
		
		Payments paymentInfo =  obj.getForObject("http://localhost:9093/payments/fetchPaymentByItemId/"+iid, Payments.class);
		
		//System.out.println(paymentInfo);
		
		// note this line You Pass the List of Payments inside items
		item.setPaymentDetails(List.of(paymentInfo));
		
		return item;
	}

	@Override
	public List<Items> fetchItemsByUid(String uid) {
		List<Items> itemsList = ir.findItemsByUid(uid);
		return itemsList;
	}
}
