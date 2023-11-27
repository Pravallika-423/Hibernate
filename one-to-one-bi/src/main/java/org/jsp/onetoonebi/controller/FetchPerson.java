package org.jsp.onetoonebi.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.onetoonebi.dto.Person;



public class FetchPerson {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Person p=manager.find(Person.class, 1);
		System.out.println(p.getCard());
	}
}
