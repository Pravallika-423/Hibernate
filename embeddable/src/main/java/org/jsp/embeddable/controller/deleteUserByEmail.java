package org.jsp.embeddable.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspembeddable.dto.User;
import org.jspembeddable.dto.UserId;

public class deleteUserByEmail {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter email of the user");
		String email = s.next();
		
		UserId id = new UserId();
		id.setEmail(email);
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		User u = manager.find(User.class,id.getEmail());
		manager.remove(u);
		transaction.begin();
		transaction.commit();
	}
}
