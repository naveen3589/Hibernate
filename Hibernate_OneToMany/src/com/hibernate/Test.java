package com.hibernate;

import java.util.HashSet;
import java.util.Set;

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

		Employee emp1=new Employee();
		emp1.setEmpName("Naveen");
		emp1.setEmpAddress("Bangalore");
		
		Employee emp2=new Employee();
		emp2.setEmpName("ysn");
		emp2.setEmpAddress("hyderabad");
		
		Employee emp3=new Employee();
		emp3.setEmpName("ysn");
		emp3.setEmpAddress("hyderabad");
		
		Employee emp4=new Employee();
		emp4.setEmpName("nvn");
		emp4.setEmpAddress("chennai");
		
		Set<Employee> employees=new HashSet<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		Department dept=new Department();
		dept.setDeptName("Computer Science");
		dept.setEmployees(employees);
		
		session.save(dept);
		t.commit();
		session.close();

		System.out.println("One to one Relationship");

	}

}






