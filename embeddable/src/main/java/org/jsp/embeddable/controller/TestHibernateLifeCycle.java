package org.jsp.embeddable.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jspembeddable.dto.Person;

public class TestHibernateLifeCycle {
public static void main(String[] args) {
	Person p=new Person();//transient state
	p.setName("ABC");
	p.setAge(22);

	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(p);//persistent state
	transaction.begin();
	transaction.commit();
	
	p.setName("virat");
	p.setAge(35);
	transaction.begin();
	transaction.commit();
	
	p.setName("Rohit");
	p.setAge(36);
	transaction.begin();
	transaction.commit();
	
	manager.detach(p);
	p.setAge(30);
	p.setName("KL Rahul");
	transaction.begin();
	transaction.commit();
}
}
