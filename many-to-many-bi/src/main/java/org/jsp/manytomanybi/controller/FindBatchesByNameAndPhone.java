package org.jsp.manytomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FindBatchesByNameAndPhone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter student name and phone");
		String name = s.next();
		long phone=s.nextLong();
		String qry = "select s.batches from Student s where s.name=?1 and s.phone=?2";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		q.setParameter(2, phone);
		List<Batch> bt = q.getResultList();
		if (bt.size() > 0) {
			for (Batch b : bt) {

				System.out.println("Batch id:" + b.getId());
				System.out.println("Batch code:" + b.getBatch_code());
				System.out.println("Subject:" + b.getSubject());
				System.out.println("trainer:" + b.getTrainer());

			}
		} else {
			System.err.println("Invalid Student name or phone...!!");
		}
	}

}
