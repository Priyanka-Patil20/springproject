package com.vwits.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class calDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("calfile.xml");
		Calculator c=context.getBean(Calculator.class);
		System.out.println(c.add(11, 12));
		System.out.println(c.sub(10, 5));
	}

}
