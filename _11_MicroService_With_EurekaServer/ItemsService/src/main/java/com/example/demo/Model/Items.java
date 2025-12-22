package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Items 
{
	@Id
	private String iid;
	private String uid;
	
	private String iname;
	private String ifeedback;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIfeedback() {
		return ifeedback;
	}
	public void setIfeedback(String ifeedback) {
		this.ifeedback = ifeedback;
	}
	@Override
	public String toString() {
		return "Items [iid=" + iid + ", uid=" + uid + ", iname=" + iname + ", ifeedback=" + ifeedback + "]";
	}
	
	
}
