package com.elbad.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elbad.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//display the Students
			System.out.println("\n\nStudents who have the last name of Doe");
			displayStudents(theStudents);
			
			
			//query students: lastName='Doe' or firstName='Daffy'
			theStudents = session.createQuery("from Student s where"
					+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			//display the Students
			System.out.println("\n\nStudents who have the last name of Doe or first name of Daffy");
			displayStudents(theStudents);
			
			//query students where email LIKE '%elbad.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%elbad.com'").getResultList();
			
			//display the Students
			System.out.println("\n\nStudents who have whose email domain is elbad.com");
			displayStudents(theStudents);
;			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
