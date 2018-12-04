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

        Department dept1=new Department();
 		dept1.setDeptName("Computer Science");
 		
		Employee emp1=new Employee();
		emp1.setEmpName("Naveen");
		emp1.setEmpAddress("Bangalore");
		emp1.setDepartment(dept1);
		
		Employee emp2=new Employee();
		emp2.setEmpName("Nav");
		emp2.setEmpAddress("Bangal");
		emp2.setDepartment(dept1);
		
		Employee emp3=new Employee();
		emp3.setEmpName("Nave");
		emp3.setEmpAddress("Bang");
		emp3.setDepartment(dept1);
		
		Employee emp4=new Employee();
		emp4.setEmpName("veen");
		emp4.setEmpAddress("Banlore");
		emp4.setDepartment(dept1);
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		t.commit();
		session.close();

		System.out.println("Many to one Relationship");

	}

}






