package org.jsp.onetoonebi.controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.onetoonebi.dto.PanCard;


public class FindAPancardById {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter pancard id");
		int id=s.nextInt();
		String jpql="select c from PanCard c where c.id=?1";
		
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q=manager.createQuery(jpql);
		q.setParameter(1,id);
		try {
			PanCard c=(PanCard)q.getSingleResult();
			System.out.println("ID : " + c.getId());
			System.out.println("Number : " + c.getNumber());
			System.out.println("DOB : " + c.getDob());
			System.out.println("pincode : " + c.getPincode());
		} 
		catch (NoResultException e) {
			
			System.err.println("Invalid id");
		}
	}

}
