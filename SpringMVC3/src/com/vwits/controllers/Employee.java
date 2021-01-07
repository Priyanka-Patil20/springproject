package com.vwits.controllers;

import java.util.List;

public class Employee {
int empid;
String name;
int salary;

public Employee(int empid, String name, int salary ) {
	super();
	this.empid = empid;
	this.name = name;
	this.salary = salary;
	
}
public Employee() {
	// TODO Auto-generated constructor stub
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + empid;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (empid != other.empid)
		return false;
	return true;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary +  "]";
}


}
