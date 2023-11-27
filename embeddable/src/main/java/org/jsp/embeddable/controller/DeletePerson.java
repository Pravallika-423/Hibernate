package org.jsp.embeddable.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jspembeddable.dto.Person;

public class DeletePerson {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	Person p=manager.find(Person.class, 2);
	
	manager.remove(p);
	transaction.begin();
	transaction.commit();
	
}
}
