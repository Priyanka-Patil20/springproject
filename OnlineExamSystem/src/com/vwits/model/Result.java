package com.vwits.model;

public class Result {
int roll_no;
String name;
int marks;
int totalmarks;
public Result(int roll_no, String name, int marks, int totalmarks) {
	super();
	this.roll_no = roll_no;
	this.name = name;
	this.marks = marks;
	this.totalmarks = totalmarks;
}
public Result() {
	
	// TODO Auto-generated constructor stub
}
public int getRoll_no() {
	return roll_no;
}
public void setRoll_no(int roll_no) {
	this.roll_no = roll_no;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public int getTotalmarks() {
	return totalmarks;
}
public void setTotalmarks(int totalmarks) {
	this.totalmarks = totalmarks;
}
@Override
public String toString() {
	return "Result [roll_no=" + roll_no + ", name=" + name + ", marks=" + marks + ", totalmarks=" + totalmarks + "]";
}

}