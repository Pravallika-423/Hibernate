package org.jsp.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebi.dto.Person;

public class FindPersonByPanCardId {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter pancard id");
		int card_id = s.nextInt();
		String qry1 = "select p from Person p where p.card.id=?1";
		String qry2="select c.person from PanCard c where c.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry1);
		q.setParameter(1, card_id);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("ID : " + p.getId());
			System.out.println("Name : " + p.getName());
			System.out.println("Phone : " + p.getPhone());
			System.out.println("Email : " + p.getEmail());

		} catch (NoResultException e) 
		{
			System.err.println("Invalid PAN Id");
		}
	}

}
