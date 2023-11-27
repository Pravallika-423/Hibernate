package org.jsp.manytoone.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Branch;

public class FindBranchByHospitalId {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter hospital id of the branch:");
		int id = s.nextInt();
		String qry = "select b from Branch b where b.hospital.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);

		List<Branch> bl = q.getResultList();
		if (bl.size() > 0) {
			for (Branch b : bl) {
				System.out.println("Hospital id:" + b.getId());
				System.out.println("name:" + b.getCity());
				System.out.println("Founder:" + b.getEmail());
				System.out.println("Year of establishment :" + b.getName());
			}
		} else {
			System.out.println("invaid hospital id...!");
		}
	}
}
