package org.jsp.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebi.dto.Person;

public class FindPersonByEmail {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter email id");
	String email=s.next();
	String jpql="select p from Person p where p.email=?1";
	
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createQuery(jpql);
	q.setParameter(1, email);
	try {
		Person p=(Person)q.getSingleResult();
		System.out.println("ID : " + p.getId());
		System.out.println("Name : " + p.getName());
		System.out.println("Phone : " + p.getPhone());
		System.out.println("Email : " + p.getEmail());

	} catch (NoResultException e) {
		System.err.println("Invalid email");
		}
}
}
