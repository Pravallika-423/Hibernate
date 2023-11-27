package org.jsp.manytomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FindBatchById {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter Id of the batch:");
		int id = s.nextInt();
		String qry = "select b from Batch b where b.id=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);

		try {
			Batch b = (Batch) q.getSingleResult();
			System.out.println("Batch id:" + b.getId());
			System.out.println("Batch code:" + b.getBatch_code());
			System.out.println("Subject:" + b.getSubject());
			System.out.println("trainer:" + b.getTrainer());

		} catch (NoResultException e) {
			System.err.println("Invalid batch id...!!");
		}
	}
}