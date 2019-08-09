package com.spring.services;

import org.springframework.stereotype.Service;

import com.spring.beans.Student;
import com.spring.dao.Dao;
import com.spring.dao.DaoImpl;

@Service
public class ServicesImpl implements Services{
	
	
	Dao db = new DaoImpl();

	@Override
	public Boolean createStudent(Student student) {
		return db.createStudent(student);
	}

	@Override
	public Student searchStudent(int regno) {
		return db.searchStudent(regno);
	}

	@Override
	public Boolean login(int adminId, String password) {
		return db.login(adminId, password);
	}

	@Override
	public Boolean deleteStudent(int regno) {
		return db.deleteStudent(regno);
	}

	@Override
	public Boolean updateStudent(int regno, String oldEmail, String newEmail) {
		return db.updateStudent(regno, oldEmail, newEmail);
	}


	@Override
	public String grade(int regno,double aggregateMarks) {
		return db.grade(regno,aggregateMarks);
	}

	@Override
	public Double aggregate(int regno, double monthlyMarks, double quarterlyMarks) {
		return db.aggregate(regno, monthlyMarks, quarterlyMarks);
	}

}
