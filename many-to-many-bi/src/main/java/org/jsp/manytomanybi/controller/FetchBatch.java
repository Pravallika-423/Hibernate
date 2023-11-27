package org.jsp.manytomanybi.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanybi.dto.Batch;



public class FetchBatch {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Batch b=manager.find(Batch.class, 1);
		System.out.println(b.getStudents());
	}
}
