package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Person;

public class DeletePerson {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter person id to delete the record");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	Person p=manager.find(Person.class, id);
	if(p!=null)
	{
		manager.remove(p);
		System.err.println("person deleted");
		transaction.begin();
		transaction.commit();
	}
	else {
		System.err.println("cannot delete Person...!!1 because the id is invalid");
	}
}
}
