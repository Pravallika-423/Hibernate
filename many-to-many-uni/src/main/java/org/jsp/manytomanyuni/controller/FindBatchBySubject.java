package org.jsp.manytomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;

public class FindBatchBySubject {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter subject");
	String sub=s.next();
	String qry="select b from Batch b where b.subject=?1";
	
	EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	Query q = manager.createQuery(qry);
	q.setParameter(1, sub);

	try {
		Batch b = (Batch) q.getSingleResult();
		System.out.println("Batch id:" + b.getId());
		System.out.println("Batch code:" + b.getBatch_code());
		System.out.println("Subject:" + b.getSubject());
		System.out.println("trainer:" + b.getTrainer());

	} catch (NoResultException e) {
		System.err.println("Invalid subject...!!");
	}
}
}

