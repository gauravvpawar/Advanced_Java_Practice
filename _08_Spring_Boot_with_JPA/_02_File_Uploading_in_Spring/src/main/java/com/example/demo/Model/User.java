package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	private String uid;
	private String uname;
	private String uemail;
	private String upassword;
	private String ucnfPassword;
	private String gender;
	private String country;
	private String phoneNumber;
	private String filename;
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
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcnfPassword() {
		return ucnfPassword;
	}
	public void setUcnfPassword(String ucnfPassword) {
		this.ucnfPassword = ucnfPassword;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", upassword=" + upassword
				+ ", ucnfPassword=" + ucnfPassword + ", gender=" + gender + ", country=" + country + ", phoneNumber="
				+ phoneNumber + ", filename=" + filename + "]";
	}
	
	
	

}
