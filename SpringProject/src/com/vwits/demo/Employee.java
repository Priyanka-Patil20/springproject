package com.vwits.demo;

public class Employee {
int id;
String name;
public Employee() {
	// TODO Auto-generated constructor stub
	System.out.println("i am constructor");
}
public Employee(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public static Employee getInstance() {
	System.out.println("Hii i am static factory");
	return new Employee();
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

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

public void hello() {
	System.out.println("Hello Employee");
}

}
