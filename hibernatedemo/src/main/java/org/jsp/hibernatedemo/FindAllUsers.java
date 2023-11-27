package org.jsp.hibernatedemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindAllUsers {
public static void main(String[] args) {
	Session s= new Configuration().configure().buildSessionFactory().openSession();
	Query<User> q=s.createQuery("select u from User u");
	List<User> users=q.getResultList();
	for(User u:users)
	{
		System.out.println("user id:"+u.getName());
		System.out.println("name: "+u.getName());
		System.out.println("phone number : "+u.getPhone());
		System.out.println("email : "+u.getEmail());
		System.out.println("==============================");
		
	}
}
}
