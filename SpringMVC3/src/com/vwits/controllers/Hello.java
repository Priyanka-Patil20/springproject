package com.vwits.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public ModelAndView doSomething() {
		System.out.println("Bingo!!!you are here");

		ModelAndView model = new ModelAndView();

		model.setViewName("welcome");
		model.addObject("data", "HELLO THIS IS SAMPLE DATA 12345");
		return model;
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public ModelAndView getEmployee(Integer empid,String ename,Integer salary) {	

		System.out.println(empid + " " + ename + " " + salary);
		ModelAndView model = new ModelAndView();
		model.setViewName("final");
		model.addObject("data",empid + " " + ename + " " + salary);
		return model;
	}
	//Get Employee details by request param annotation
	
	@RequestMapping(value = "/emp1", method = RequestMethod.POST)
	public ModelAndView getEmp( @RequestParam("empid") Integer a, @RequestParam("ename") String b, @RequestParam("salary") Integer c) {	
		EmployeeDao d=new EmployeeDao();
		System.out.println(a + " " + b + " " + c);
		Employee e=new Employee(a,b,c);
		d.insert(e);
		System.out.println(d.getAll());
		ModelAndView model = new ModelAndView();
		model.setViewName("final");
		model.addObject("data",b + " " + a + " " + c);
		return model;
	}
	
	//read the data from url
	@RequestMapping(value = "/read/{eid}", method = RequestMethod.GET)
	public ModelAndView getEmpid(@PathVariable("eid") int empid ) {	

		System.out.println(empid);
		ModelAndView model = new ModelAndView();
		model.setViewName("new");          //works like RequestDispatcher in servlet
		model.addObject("data"," "+ empid);
		return model;
	}


}