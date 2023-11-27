package org.jsp.onetoonebi.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebi.dto.Person;

public class FindPersonByDobAndPANCardNumber {
public static void main(String[] args) {
	String qry1="select p from Person p where p.card.dob=?1 and p.card.number=?2";
	String qry2="select c.person from PanCard c where c.dob=?1 and c.number=?2";
	
	Scanner s=new Scanner(System.in);
	System.out.println("enter DOB(yyyy-mm--dd) and pancard number..");
	LocalDate dob=LocalDate.parse(s.next());
	String number=s.next();
	
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createQuery(qry1);
	q.setParameter(1, dob);
	q.setParameter(2, number);
	try {
		Person p=(Person) q.getSingleResult();
		System.out.println("Person id : "+p.getId() );
		System.out.println("name : "+p.getName());
		System.out.println("phone : "+p.getPhone());
		System.out.println("email : "+p.getEmail());
	}
	catch(NoResultException e)
	{
		System.out.println("enter valid PANcard number or DOB");
	}
}
}
