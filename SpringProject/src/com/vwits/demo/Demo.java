package com.vwits.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("myfile.xml");
		Employee e=context.getBean(Employee.class);
		e.hello();
		System.out.println(e);
		Employee e1=context.getBean(Employee.class);
		e1.hello();
		System.out.println(e1);
	}
}
 