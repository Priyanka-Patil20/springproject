package com.vwits.demo;

public class Employee {
int id;
String name;
int Salary;
Address address;
public Employee(int id, String name, int salary, Address address) {
	super();
	this.id = id;
	this.name = name;
	Salary = salary;
	this.address = address;
}
public Employee() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return Salary;
}
public void setSalary(int salary) {
	Salary = salary;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", Salary=" + Salary + ", address=" + address + "]";
}

}
