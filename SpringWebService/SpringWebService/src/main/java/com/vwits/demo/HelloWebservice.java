package com.vwits.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vwits.javabean.Employee;

@RestController
public class HelloWebservice {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value="/emp", method = RequestMethod.GET)
	public List<Employee> getEmp() {
		Employee e1 = new Employee(1, "abc", 24000);
		Employee e2 = new Employee(1, "abc", 24000);
		Employee e3 = new Employee(1, "abc", 24000);
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		return list;
	}
	
	/*
	 * since when using post, content comes in request body (for inserting use post method)
	 * in postman, create request post > body > select json write 
	 * {
        "empid": 12,
        "name": "xyz",
        "salary": 25000
    	} 
    	then in url > localhost:8886/insert. 
	 */
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public Employee insertEmployee(@RequestBody Employee e) {
		System.out.println(e);
		return e;
	}
}
