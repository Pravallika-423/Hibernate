package org.jsp.manytomanyuni.controller;

import java.util.Scanner;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;

public class FindBatchByBatchId {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter batch code:");
		String batch_code = s.next();
		String qry = "select b from Batch b where b.batch_code=?1 ";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, batch_code);

		try {
			Batch b = (Batch) q.getSingleResult();
			System.out.println("Batch id:" + b.getId());
			System.out.println("Batch code:" + b.getBatch_code());
			System.out.println("Subject:" + b.getSubject());
			System.out.println("trainer:" + b.getTrainer());

		} catch (NoResultException e) {
			System.err.println("Invalid batch code...!!");
		}
	}
}
