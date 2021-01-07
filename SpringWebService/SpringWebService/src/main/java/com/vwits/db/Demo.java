package com.vwits.db;

import com.vwits.javabean.Employee;

public class Demo {
	public static void main(String[] args) {
		EmployeeDAOImpl emp = new EmployeeDAOImpl();
		Employee e = new Employee(11, "pqr", 53);
		emp.saveEmp(e);
		System.out.println(emp.getAll());
	}
}
