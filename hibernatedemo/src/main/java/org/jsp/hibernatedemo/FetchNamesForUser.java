package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchNamesForUser {

	public static void main(String[] args) {

		String qry = "select name from User u";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(qry);

		List<User> users = q.getResultList();

		for (User u : users) {
			System.out.println("User id: " + u.getId());
			System.out.println("Name : " + u.getName());
			System.out.println("phone number :" + u.getPhone());
			System.out.println("email : " + u.getPhone());
			System.out.println("=============================");

		}
	}
}
