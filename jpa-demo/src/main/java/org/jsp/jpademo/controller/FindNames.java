package org.jsp.jpademo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindNames {
	public static void main(String[] args) {
		String jpql = "select p.name from Person p";
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(jpql);
		List<String> ps = q.getResultList();
		for (String p : ps) {
			System.out.println(p);
		}
	}
}
