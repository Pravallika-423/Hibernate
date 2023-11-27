package org.jsp.embeddable.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jspembeddable.dto.User;
import org.jspembeddable.dto.UserId;

public class SaveUser {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		System.out.println("Enter email and phone number");
		UserId id = new UserId();
		id.setEmail(s.next());
		id.setPhone(s.nextLong());

		System.out.println("enter name and age:");
		User u = new User();
		u.setName(s.next());
		u.setAge(s.nextInt());
		u.setId(id);

		manager.persist(u);
		transaction.begin();
		transaction.commit();

		System.out.println("User saved Susscessfully...!!");
	}
}
