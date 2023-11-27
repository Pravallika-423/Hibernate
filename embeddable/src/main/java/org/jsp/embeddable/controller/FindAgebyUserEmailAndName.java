package org.jsp.embeddable.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspembeddable.dto.UserId;

public class FindAgebyUserEmailAndName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter name and email of the user");
		String name = s.next();
		String email = s.next();
		String qry = "select u.age from User u where u.id.email=?1 and u.name=?2";
		UserId id = new UserId();
		id.setEmail(email);
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id.getEmail());
		q.setParameter(2, name);
		List<Integer> us = q.getResultList();
		if (us != null) {
			for (Integer u : us) {
				System.out.println(u);
			}
		} else {
			System.err.println("invalid email or name");
		}
	}
}
