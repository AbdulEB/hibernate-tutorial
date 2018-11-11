package com.elbad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elbad.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a employee object
			System.out.println("Create new employee object...");
			Employee tempEmployee1 = new Employee("P", "Skills", "Raptors");
			Employee tempEmployee2 = new Employee("Adam", "T", "Vikings");
			Employee tempEmployee3 = new Employee("John", "T", "Maple Leafs");
			Employee tempEmployee4 = new Employee("Chris", "Ronaldo", "Juventus");
			
			//start a transaction
			session.beginTransaction();
			
			//save the employee object
			System.out.println("saving the employee...");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			session.save(tempEmployee4);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
