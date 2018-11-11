package com.elbad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elbad.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

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
			Employee tempEmployee = new Employee("K", "Low", "Raptors");
			
			//start a transaction
			session.beginTransaction();
			
			//save the employee object
			System.out.println("saving the employee...");
			System.out.println(tempEmployee);
			session.save(tempEmployee);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
			
		}
		finally {
			factory.close();
		}

	}

}
