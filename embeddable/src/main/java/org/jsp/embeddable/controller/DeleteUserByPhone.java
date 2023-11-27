package org.jsp.embeddable.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jspembeddable.dto.User;
import org.jspembeddable.dto.UserId;

public class DeleteUserByPhone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter phone number of the user");
		long phone = s.nextLong();

		UserId id = new UserId();
		id.setPhone(phone);
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		User u = manager.find(User.class, id.getPhone());
		manager.remove(u);
		transaction.begin();
		transaction.commit();
	}
}
