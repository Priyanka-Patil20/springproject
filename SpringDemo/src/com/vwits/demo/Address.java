package com.vwits.demo;

public class Address {
String city;
int zipcode;
public Address(String city, int zipcode) {
	super();
	this.city = city;
	this.zipcode = zipcode;
}
public Address() {
	// TODO Auto-generated constructor stub
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getZipcode() {
	return zipcode;
}
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}
@Override
public String toString() {
	return "Address [city=" + city + ", zipcode=" + zipcode + "]";
}

}
