package com.spring.services;

import com.spring.beans.Student;

public interface Services {

	
	public Boolean createStudent(Student student);
	
	public Student searchStudent(int regno);
	
	public Boolean login(int adminId,String password);
	
	public Boolean deleteStudent(int regno);
	
	public Boolean updateStudent(int regno,String oldEmail,String newEmail);
	
	public Double aggregate(int regno,double monthlyMarks,double quarterlyMarks);
	
	public String grade(int regno,double aggregateMarks);

}
