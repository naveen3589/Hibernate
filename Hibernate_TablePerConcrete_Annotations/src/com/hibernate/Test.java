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

		Cheque cheque=new Cheque();
		cheque.setAmount(45000);
		cheque.setChequeType("ICICI");
		
		CreditCard card=new CreditCard();
		card.setAmount(75000);
		card.setCreditCardType("Platinum");
		
		session.save(cheque);
		session.save(card);
		t.commit();
		session.close();

		System.out.println("TablePerConcreteClass using Annotations");

	}
}















