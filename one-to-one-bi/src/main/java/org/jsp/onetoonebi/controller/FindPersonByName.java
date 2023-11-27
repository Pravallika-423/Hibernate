package org.jsp.onetoonebi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.service.spi.Manageable;
import org.jsp.onetoonebi.dto.Person;

public class FindPersonByName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter name of the person:");
		String name = s.next();
		String jpql = "select p from Person p where p.name=?1";

		EntityManager manger = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manger.createQuery(jpql);
		q.setParameter(1, name);
		List<Person> ps = q.getResultList();
		if (ps.size() > 0) {
			for (Person p : ps) {
				System.out.println("ID : " + p.getId());
				System.out.println("Name : " + p.getName());
				System.out.println("Phone : " + p.getPhone());
				System.out.println("Email : " + p.getEmail());
				System.err.println("=======================");
			}
		}

		else {
			System.out.println("Person doesnot present with given name");
		}
	}
}