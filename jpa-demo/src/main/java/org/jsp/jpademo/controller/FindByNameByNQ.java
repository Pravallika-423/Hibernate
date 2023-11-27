package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class FindByNameByNQ {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter person name to dsiplay details..");
	String name=s.next();
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q=manager.createNamedQuery("findByName");
	q.setParameter(1, name);
	List<Person> ps=q.getResultList();
	if(ps.size()>0) {
		for(Person p:ps)
		{
			
				System.out.println("person id:"+p.getId());
				System.out.println("name : "+p.getName());
				System.out.println("phone: "+p.getPhone());
				System.out.println("email: "+p.getEmail());
				System.out.println("gender: "+p.getGender());
				System.out.println("age: "+p.getAge());
			
		}
	}
	else {
		System.err.println("No person found with given name...!!");
	}
}
}
