package com.spring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students_info")
public class Student {

	
	@Id
	private int regno;
	private String fname;
	private String lname;
	private String email;
	private double monthlyMarks;
	private double quaterlyMarks;
	private double aggregateMarks;
	private String password;
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMonthlyMarks() {
		return monthlyMarks;
	}
	public void setMonthlyMarks(double monthlyMarks) {
		this.monthlyMarks = monthlyMarks;
	}
	public double getQuaterlyMarks() {
		return quaterlyMarks;
	}
	public void setQuaterlyMarks(double quaterlyMarks) {
		this.quaterlyMarks = quaterlyMarks;
	}
	public double getAggregateMarks() {
		return aggregateMarks;
	}
	public void setAggregateMarks(double aggregateMarks) {
		this.aggregateMarks = aggregateMarks;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [regno=" + regno + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", monthlyMarks=" + monthlyMarks + ", quaterlyMarks=" + quaterlyMarks + ", aggregateMarks="
				+ aggregateMarks + "]";
	}
	
	
	
}
