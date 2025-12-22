package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Users 
{
	@Id
	private String uid;
	private String uname;
	private String uemail;
	
	// transient annotation is used for you dont that column in your database
	@Transient
	private List<Items> itemList = new ArrayList<Items>();

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", itemList=" + itemList + "]";
	}
	
	
	
	
	
}
