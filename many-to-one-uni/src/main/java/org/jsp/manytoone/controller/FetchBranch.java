package org.jsp.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytoone.dto.Branch;



public class FetchBranch {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Branch b=manager.find(Branch.class, 1);
		System.out.println(b.getHospital());
	}
}
