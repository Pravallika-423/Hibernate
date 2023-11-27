package org.jsp.embeddable.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jspembeddable.dto.Person;

public class UpdatePerson {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	Person p=manager.find(Person.class,3);//persistent state
	p.setAge(32);
	transaction.begin();
	transaction.commit();
}
}
