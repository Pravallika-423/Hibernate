package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAgeByGender {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter gender");
	String gender=s.next();
	String jpql="select p.age from Person p where p.gender=?1";
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	
	Query q = manager.createQuery(jpql);
	q.setParameter(1, gender);
	List<Integer> ps=q.getResultList();
	for(int p:ps)
	{
		System.out.println(p);
	}
	
}
}

