package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUserById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter ur id to delete the record");
		int id=sc.nextInt();
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		User u=s.get(User.class, id);
		if(u!=null)
		{
			Transaction t=s.beginTransaction();
			s.delete(u);
			t.commit();
		}else {
			System.err.println("you have entered an invalid id");
		}

	}
}
