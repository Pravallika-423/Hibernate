package org.jsp.jpademo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import org.jsp.jpademo.dto.Person;

public class SavePerson {
public static void main(String[] args) {
	Person p=new Person();
	p.setName("varsha");
	p.setAge(23);
	p.setEmail("v@gmail.com");
	p.setGender("female");
	p.setPhone(778899);
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("jpa");
	EntityManager manager=factory.createEntityManager();
	manager.persist(p);
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	transaction.commit();
	
	System.out.println("Person saved with Id :"+p.getId());
	

}
	
}
