package org.jsp.manytomanybi.controller;

import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;
import org.jsp.manytomanybi.dto.Student;

public class FindStudentByBatch_id {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter batch id");
		int id=s.nextInt();
		
		String qry = "select b.students from Batch b where b.id=?1";

		EntityManager manager = Persistence.createEntityManagerFactory("jpa").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);

		List<Student> st = q.getResultList();
		if (st.size() > 0) {
			for (Student s1 : st) {
				System.out.println("Student id:" + s1.getId());
				System.out.println("name:" + s1.getName());
				System.out.println("percantage:" + s1.getPercentage());
				System.out.println("phone number:" + s1.getPhone());
			}
		} else {
			System.err.println("no student found in given batch id...!!");
		}
	}
}
