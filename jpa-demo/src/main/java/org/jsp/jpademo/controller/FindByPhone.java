package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class FindByPhone {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the phone number to display person details :");
		long phone=s.nextLong();
		String jpql="select p from Person p where p.phone=?1";
		
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q=manager.createQuery(jpql);
		q.setParameter(1,phone);
		try {
			Person p=(Person)q.getSingleResult();
			System.out.println("person id :"+p.getId());
			System.out.println("name :"+p.getName());
			System.out.println("phone : "+p.getPhone());
			System.out.println("email : "+p.getEmail());
			System.out.println("gender: "+p.getGender());
			System.out.println("age : "+p.getAge());
		}
		catch (NoResultException e) {
			System.err.println("invalid phone number...!!!");
		}
	}
}
