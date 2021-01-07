package com.vwits.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vwits.db.EmployeeDAOImpl;
import com.vwits.javabean.Employee;

@RestController
public class EmployeeCrudOperations {
	private ApplicationContext context = new AnnotationConfigApplicationContext("com.vwits.db");;
	EmployeeDAOImpl data = context.getBean(EmployeeDAOImpl.class);
	
	@GetMapping(value="/getAll")
	public List<Employee> getAll() {
		return data.getAll();
	}
	
	@PostMapping(value = "/save")
	public Employee insert(@RequestBody Employee e) {
		data.saveEmp(e);
		return e;
	}
	
	@PutMapping(value="/update")
	public Employee update(@RequestBody Employee e) {
		
		data.updateEmp(e);
		return e;
	}
	
	@DeleteMapping(value = "/delete")
	public Employee delete(@RequestBody Employee e) {
		data.removeEmp(e);
		return e;
	}
	
	/*
	 * url = localhost:8886/emp/12   (here 12 is empid)
	 */
	@GetMapping("/emp/{empid}")
	public List getEmployee(@PathVariable("name") String name) {
		List<Employee> e = data.getEmp(name);
		return e;
	}
}
