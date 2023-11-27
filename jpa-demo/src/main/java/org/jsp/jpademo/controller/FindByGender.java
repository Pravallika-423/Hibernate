package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class FindByGender {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter gender to display details..");
		String gender = s.next();
		String jpql = "select p from Person p where p.gender=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, gender);
		List<Person> ps = q.getResultList();
		if (ps.isEmpty() == false) {
			for (Person p : ps) {
				System.out.println("ID : " + p.getId());
				System.out.println("Name : " + p.getName());
				System.out.println("Phone : " + p.getPhone());
				System.out.println("Email : " + p.getEmail());
				System.out.println("Gender : " + p.getGender());
				System.out.println("Age : " + p.getAge());
				System.err.println("=======================");
			}
		} else {
			System.err.println("invalid gender....!!!");
		}

	}
}
