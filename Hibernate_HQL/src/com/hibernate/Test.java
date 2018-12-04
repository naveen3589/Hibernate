package com.hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
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
          
        Transaction transaction=session.beginTransaction();    
        
        Criteria c=session.createCriteria(Employee.class);
        List<Employee> list=c.list();

        Iterator itr=list.iterator();

        while(itr.hasNext()){

        Employee employee=(Employee)itr.next();

        System.out.println(employee.getEmpId()+" "+employee.getEmpName()+" "+employee.getEmpSalary()+" "+employee.getEmpAddress());

        }
        
        transaction.commit();
        

        List list=uery.list();

        Iterator itr=list.iterator();

        while(itr.hasNext()){

        Employee employee=(Employee)itr.next();

        System.out.println(employee.getEmpId()+" "+employee.getEmpName()+" "+employee.getEmpSalary()+" "+employee.getEmpAddress());
        
        }

	}

}








