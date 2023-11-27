package org.jsp.jpademo.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;



public class FindAll {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	String jpql="select p from Person p";
	Query q=manager.createQuery(jpql);
	List<Person>  ps=q.getResultList();
	for(Person p:ps)
	{
		System.out.println("person id :"+p.getId());
		System.out.println("name: "+p.getName());
		System.out.println("phone : "+p.getPhone());
		System.out.println("email : "+p.getEmail());
		System.out.println("gemder : "+p.getGender());
		System.out.println("age : "+p.getAge());
		System.err.println("=============================");
	}
	
}
}
