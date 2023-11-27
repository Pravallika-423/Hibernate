package org.jsp.embeddable.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jspembeddable.dto.User;
import org.jspembeddable.dto.UserId;

public class deleteUserByPk {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		System.out.println("enter email and phone");
		UserId id=new UserId();
		String email=s.next();
		long phone=s.nextLong();
		User u=manager.find(User.class, id);
		
		if(u!=null) {
		manager.remove(u);
		System.out.println("user deleted");
		transaction.begin();
		transaction.commit();
		}
		else {
			System.out.println("cannot delete..invalid primarykey");
		}
		
	}
}
