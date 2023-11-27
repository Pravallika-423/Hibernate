package org.jsp.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebi.dto.Person;

public class FindPersonByPanCardNumber {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter pancard number");
	String number =s.next();
	String qry="select p from Person p where p.card.number=?1";
	
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createQuery(qry);
	q.setParameter(1, number);
	try {
		Person p=(Person) q.getSingleResult();
		System.out.println("person id:"+p.getId());
		System.out.println("name:"+p.getName());
		System.out.println("phone : "+p.getPhone());
		System.out.println("email : "+p.getEmail());
		}
	catch(NoResultException e) {
		System.out.println("invalid pan number");
	}
}
}
