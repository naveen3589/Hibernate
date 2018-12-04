package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
          
         Transaction t=session.beginTransaction();    

		Employee emp=new Employee();
		emp.setName("Naveen");
		emp.setSalary(65000);
		
		Address address=new Address();
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		
		address.setEmployee(emp);
		emp.setAddress(address);
		
		session.save(emp);
		t.commit();
		session.close();

		System.out.println("One to one Relationship");

	}

}



