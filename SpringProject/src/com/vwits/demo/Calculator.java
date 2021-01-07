package com.vwits.demo;

public class Calculator {
	int a;
	int b;
	public Calculator() {
		// TODO Auto-generated constructor stub
		System.out.println("This is constructor");
	}
	public int add(int a, int b) {
		int c=a+b;
		return c;
	}
	public int sub(int a, int b) {
		int c=a-b;
		return c;
	}
	public int mul(int a, int b) {
		int c=a*b;
		return c;
	}

}
