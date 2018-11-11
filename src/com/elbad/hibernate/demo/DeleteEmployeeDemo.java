package com.elbad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.elbad.hibernate.demo.entity.Employee;
import com.elbad.hibernate.demo.entity.Student;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int employeeId = 3;

			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			//delete the employee
//			System.out.println("Deleting employee: " + myEmployee);
//			session.delete(myEmployee);
			
			//delete employee id=2
			System.out.println("Deleting employee id=2");
			session.createQuery("delete from Employee where id>6").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			//NEW CODE
			
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
