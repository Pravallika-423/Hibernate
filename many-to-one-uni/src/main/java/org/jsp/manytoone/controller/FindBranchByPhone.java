package org.jsp.manytoone.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Branch;

public class FindBranchByPhone {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter phone number of the branch:");
		long phone = s.nextLong();
		String qry = "select b from Branch b where b.phone=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);

		try {
			Branch b = (Branch) q.getSingleResult();
			System.out.println("Hospital id:" + b.getId());
			System.out.println("name:" + b.getCity());
			System.out.println("Founder:" + b.getEmail());
			System.out.println("Year of establishment :" + b.getName());
		} catch (NoResultException e) {
			System.err.println("Invalid branch phone number");
		}
	}
}
