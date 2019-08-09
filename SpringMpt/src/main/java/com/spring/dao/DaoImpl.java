package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.spring.beans.Admin;
import com.spring.beans.Student;

@Repository
public class DaoImpl implements Dao{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
	@Override
	public Boolean createStudent(Student student) {
		
		Boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return state;
	}

	@Override
	public Student searchStudent(int regno) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from Student s where s.regno=:regno ");
		query.setParameter("regno", regno);
		em.getTransaction().begin();
		List student = query.getResultList();
		em.getTransaction().commit();
		Student  student1 =  (Student) student.get(0);
		return student1;
	}

	@Override
	public Boolean login(int adminId, String password) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Admin> query = em.createQuery("from Admin s where s.adminId=:adminId and password= :password", Admin.class);
			query.setParameter("adminId", adminId);
			query.setParameter("password", password);
			List<Admin> admins = query.getResultList();
			Admin admin = admins.get(0);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteStudent(int regno) {
		EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Student  student = em.find(Student.class, regno);
			em.remove(student);
			em.getTransaction().commit();
			return true;
	}

	@Override
	public Boolean updateStudent(int regno,String oldEmail, String newEmail) {
		Boolean state = true;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			javax.persistence.Query query = em
					.createQuery("Update Student s set s.email=:newEmail where s.email= :oldEmail and regno=:regno ");
			query.setParameter("newEmail", newEmail);
			query.setParameter("regno", regno);
			query.setParameter("oldEmail", oldEmail);
			int updateCount = query.executeUpdate();
			em.getTransaction().commit();
			em.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return state;
	}

	@Override
	public Double aggregate(int regno,double monthlyMarks,double quarterlyMarks) {
		Double aggregateMarks= ((monthlyMarks + quarterlyMarks)/2)/10;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("Update Student s set s.monthlyMarks= :monthlyMarks,s.quaterlyMarks= :quarterlyMarks"
					+ ",s.aggregateMarks= :aggregateMarks where regno= :regno");
			query.setParameter("monthlyMarks", monthlyMarks);
			query.setParameter("quarterlyMarks", quarterlyMarks);
			query.setParameter("aggregateMarks", aggregateMarks);
			query.setParameter("regno", regno);
			int update = query.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return aggregateMarks;
		
		
	}

	@Override
	public String grade(int regno,double aggregateMarks) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> query = em.createQuery("from Student s where regno= :regno and aggregateMarks= :aggregateMarks", Student.class);
		query.setParameter("regno", regno);
		query.setParameter("aggregateMarks", aggregateMarks);
		List<Student> users = query.getResultList();
		Student student = users.get(0);
		em.getTransaction().commit();
		if(student != null) {
		String grade="Improper value";
	 if(aggregateMarks >9.10 && aggregateMarks<10.00) {
		  grade = "A+";
	 }else if(aggregateMarks>8.10){
		  grade = "A";
	 }else if(aggregateMarks>7.10){
		  grade = "B";
	 }else if(aggregateMarks>6.10){
		 grade = "C";
	 }else if(aggregateMarks>5.10){
		 grade = "D";
	 }else if(aggregateMarks>4.10){
		  grade = "E";
	 }else if(aggregateMarks<4.00){
		  grade = "Fail";
	 }
	return grade;
	}
	return null;
	}

}
