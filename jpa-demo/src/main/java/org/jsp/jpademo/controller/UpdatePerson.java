package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import org.jsp.jpademo.dto.Person;

public class UpdatePerson {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter person id to update");
		int id=s.nextInt();
		System.out.println("enter age,name,phone,gender and email");
		Person p=new Person();
		p.setId(id);
		p.setAge(s.nextInt());
		p.setName(s.next());
		p.setPhone(s.nextLong());
		p.setGender(s.next());
		p.setEmail(s.next());
		
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		manager.merge(p);
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		transaction.commit();
		
		System.out.println("Person with id "+p.getId()+" is updated");
	}
}
