package org.jsp.manytomanybi.controller;

import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FindBatchByTrainer {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter trainer");
		String sub = s.next();
		String qry = "select b from Batch b where b.trainer=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, sub);
		List<Batch> bt = q.getResultList();
		if (bt.size() > 0) {
			for (Batch b : bt) {

				System.out.println("Batch id:" + b.getId());
				System.out.println("Batch code:" + b.getBatch_code());
				System.out.println("Subject:" + b.getSubject());
				System.out.println("trainer:" + b.getTrainer());

			}
		} else {
			System.err.println("Invalid trainer...!!");
		}
	}
}
