package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payments 
{
	@Id
	private String pid;
	private String iid;
	private String amount;
	private String payment_mode;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	@Override
	public String toString() {
		return "Payments [pid=" + pid + ", iid=" + iid + ", amount=" + amount + ", payment_mode=" + payment_mode + "]";
	}
	
	
	
}
