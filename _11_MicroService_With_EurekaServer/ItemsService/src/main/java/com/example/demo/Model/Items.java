package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Items 
{
	@Id
	private String iid;
	private String uid;
	
	private String iname;
	private String ifeedback;

	@Transient
	private List<Payments> paymentDetails = new ArrayList<Payments>();

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

	public List<Payments> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<Payments> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	@Override
	public String toString() {
		return "Items [iid=" + iid + ", uid=" + uid + ", iname=" + iname + ", ifeedback=" + ifeedback
				+ ", paymentDetails=" + paymentDetails + "]";
	}
	
	
	
}
