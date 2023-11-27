package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Person;

public class FindByPersonId {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter person id to display details ");
	int id=s.nextInt();
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Person p=manager.find(Person.class,id);
	if(p!=null)
	{
		System.out.println("person id :"+p.getId());
		System.out.println("name :"+p.getName());
		System.out.println("phone : "+p.getPhone());
		System.out.println("email id : "+p.getId());
		System.out.println("gender : "+p.getGender());
		System.out.println("age : "+p.getAge());
		
	}
	else {
		System.err.println("You have entered an invalid Id");
	}
	
	
}
}
