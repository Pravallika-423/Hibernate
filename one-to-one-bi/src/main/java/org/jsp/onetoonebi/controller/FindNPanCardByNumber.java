package org.jsp.onetoonebi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoonebi.dto.PanCard;

public class FindNPanCardByNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter PAN number :");
		String number = s.next();
		String qry = "select c from PanCard c where c.number=?1" ;

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		try {
			PanCard c=(PanCard) q.getSingleResult();
			System.out.println("ID : " + c.getId());
			System.out.println("Number : " + c.getNumber());
			System.out.println("DOB : " + c.getDob());
			System.out.println("pincode : " + c.getPincode());
		}
		catch(NoResultException E) 
		{
			System.out.println("enter valid pan number....");
		}
	}
}
