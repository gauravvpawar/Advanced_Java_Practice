package com.First;

public class Clinic 
{
	private String clinicName;
	private String clinicAddress;
	private int clinicPincode;
	
	private Doctor d1;

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public int getClinicPincode() {
		return clinicPincode;
	}

	public void setClinicPincode(int clinicPincode) {
		this.clinicPincode = clinicPincode;
	}

	public Doctor getD1() {
		return d1;
	}

	public void setD1(Doctor d1) {
		this.d1 = d1;
	}
	
	public void showData()
	{
		
		System.out.println("Doctor data : ");
		System.out.println("Doctor id : " + d1.getDid());
		System.out.println("Doctor name : " + d1.getDname());
		System.out.println("Doctor email : " + d1.getDemail());
		
		System.out.println("Patiet Details : ");
		System.out.println("Patient id : " + d1.getP1().getPid());
		System.out.println("Patient name : " + d1.getP1().getPname());
		System.out.println("Patient age : " + d1.getP1().getPage());
		System.out.println("Patient Disease : " + d1.getP1().getPdisease());
			
	}
}
