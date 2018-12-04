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

        Categories c1=new Categories();
        c1.setCategoryName("MI");
        Categories c2=new Categories();
        c2.setCategoryName("OnePlus");
        
        Item i1=new Item();
        i1.setItemName("Mobile");
        Item i2=new Item();
        i2.setItemName("Laptop");
		
		Set<Item> s=new HashSet<Item>();
		s.add(i1);
		s.add(i2);
		
		c1.setItems(s);
		c2.setItems(s);
		
		session.save(c1);
		session.save(c2);
		
		t.commit();
		session.close();

		System.out.println("Many to Many Relationship");

	}

}








