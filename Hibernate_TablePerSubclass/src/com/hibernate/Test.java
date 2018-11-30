package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Cheque cheque=new Cheque();
		cheque.setChequeType("ICICI");
		cheque.setAmount(45000);
		
		CreditCard card=new CreditCard();
		card.setCreditCardType("Platinum");
		card.setAmount(75000);

		session.save(cheque);
		session.save(card);
		transaction.commit();
		session.close();

		System.out.println("Inserted Successfully: TablePerSubClass");

	}
}










