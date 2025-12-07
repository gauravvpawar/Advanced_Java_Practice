package _02_Embedabble_info._02_Embedabble_info;

import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String area;
	private String city;
	private int pincode;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [area=" + area + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
}
