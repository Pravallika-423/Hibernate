package org.jsp.hibernatedemo;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id to update");
		int id=sc.nextInt();
		User u=new User();
		u.setId(id);
		System.out.println("enter name,email,phone and password to update :");
		u.setName(sc.next());
		u.setEmail(sc.next());
		u.setPhone(sc.nextLong());
		u.setPassword(sc.next());
		
		
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(u);
		t.commit();
		System.out.println("User updated");
}
}