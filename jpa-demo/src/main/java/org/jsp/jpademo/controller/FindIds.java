package org.jsp.jpademo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

//import org.jsp.jpademo.dto.Person;

public class FindIds {
	public static void main(String[] args) {
		String jpql="select p.id from Person p";
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q=manager.createQuery(jpql);
		List<Integer> ps=q.getResultList();
		for(int p:ps)
		{
			System.out.println(p);
		}
	}
}
