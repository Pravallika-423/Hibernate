package org.jsp.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebi.dto.PanCard;
import org.jsp.onetoonebi.dto.Person;

public class FindPanCardByPersonId {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter person id to find pancard details");
	int id=s.nextInt();
	String qry="select c from PanCard c where c.person.id=?1";
	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q = manager.createQuery(qry);
	
	q.setParameter(1,id);
	try {
		PanCard c= (PanCard) q.getSingleResult();
		System.out.println("ID : " + c.getId());
		System.out.println("pan number : " + c.getNumber());
		System.out.println("pincode : " + c.getPincode());
		System.out.println("DOB : " + c.getDob());

	} catch (NoResultException e) 
	{
		System.err.println("Invalid Person Id");
	}
}
}
