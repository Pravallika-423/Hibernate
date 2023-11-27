package org.jsp.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebi.dto.PanCard;

public class FindpanCardByPersonPhoneAndEmail {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter person Phone and email to display pancard details..");
	Long phone = s.nextLong();
	String email = s.next();
	String qry = "select c from PanCard c where c.person.phone=?1 and c.person.email=?2";

	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, phone);
	q.setParameter(2, email);
	try {
		PanCard c = (PanCard) q.getSingleResult();
		System.out.println("ID : " + c.getId());
		System.out.println("pan number : " + c.getNumber());
		System.out.println("pincode : " + c.getPincode());
		System.out.println("DOB : " + c.getDob());

	} catch (NoResultException e) {
		System.err.println("Invalid Person phone number or email...");
	}
}
}
