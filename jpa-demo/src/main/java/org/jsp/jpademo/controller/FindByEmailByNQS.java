package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class FindByEmailByNQS {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the phone number to display person details..");
	String email=s.next();
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createNamedQuery("findByEmail");
	q.setParameter(1, email);
	List<Person> ps=q.getResultList();
	if(ps.size()>0)
	{
		for(Person p:ps) {
		System.out.println("person id : "+p.getId());
		System.out.println("name: "+p.getName() );
		System.out.println("phone : "+p.getPhone());
		System.out.println("email : "+p.getEmail());
		System.out.println("Gender : "+p.getGender());
		System.out.println("Age : "+p.getAge());
	}
	}
	else {
		System.err.println("Invalid Email ID");
	}
	
}
}
