package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class VerifyUser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter phone number and password to verify user");
		long phone=sc.nextLong();
		String password  =sc.next();
		String qry="select u from User u where u.phone=:ph and u.password=:ps" ;
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter("ph",phone);
		q.setParameter("ps",password);
		try {
			User u=q.getSingleResult();
			System.out.println("user verified successfully");
			System.out.println("user id:"+u.getId());
			System.out.println("name : "+u.getName());
			System.out.println("phone : "+u.getPhone());
			System.out.println("email : "+u.getEmail());
			System.out.println("=========================");
		}
		catch(NoResultException e) {
			System.err.println("invalid phone number or password");
		}
	}
}

