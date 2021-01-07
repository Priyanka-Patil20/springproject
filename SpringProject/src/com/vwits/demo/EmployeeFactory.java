package com.vwits.demo;

public class EmployeeFactory {
public Employee getEmployee() {
	System.out.println("Factory class method being called");
	return new Employee();
}
}
