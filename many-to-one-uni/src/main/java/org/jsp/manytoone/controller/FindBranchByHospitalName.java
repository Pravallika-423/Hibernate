package org.jsp.manytoone.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Branch;

public class FindBranchByHospitalName {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter hospital name of the branch:");
		String name= s.nextLine();
		String qry = "select b from Branch b where b.hospital.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);

		List<Branch> bl = q.getResultList();
		if (bl.size() > 0) {
			for (Branch b : bl) {
				System.out.println("Hospital id:" + b.getId());
				System.out.println("name:" + b.getCity());
				System.out.println("Founder:" + b.getEmail());
				System.out.println("Year of establishment :" + b.getName());
			}
		} else {
			System.out.println("invaid hospital name...!!");
		}
	}
}
