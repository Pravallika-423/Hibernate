package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindNameByAge {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter age");
		int age=s.nextInt();
		String jpql="select p.name from Person p where p.age=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		
		Query q = manager.createQuery(jpql);
		q.setParameter(1, age);
		List<String> ps=q.getResultList();
		for(String p:ps)
		{
			System.out.println(p);
		}
		
	}

}
